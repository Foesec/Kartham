package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class PlayingField {

	enum Phase {
		INIT, BEGIN, DRAWING, EXECUTION, ENDROUND
	}
	enum SubPhase {
		NONE, ITEM
	}

	private Phase phase = Phase.INIT;
	private SubPhase subphase = SubPhase.NONE;

	// display information and important positions
	private OrthographicCamera camera;
	private int cardX = 0, cardY = 0;
	private int dispW = 0, dispH = 0;

	private Array<Card> bag = new Array<Card>();
	private Texture bg;
	private int bagCardSize = 128;
	private int fieldCardSize = 128;
	private String debugLog = "";
	private BitmapFont ltFontL, dkFontS, dkFontL;
	
	// timing
	private float timer = 0.0f;

	// textover
	private Texture textoverTex = new Texture(
			Gdx.files.internal("textover.png"));
	private Sprite textoverSprite = new Sprite(textoverTex);

	// player
	private Player player;

	// tooltip handling
	private Sprite tooltipSprite;
	private boolean showTooltip = false;
	private String tooltipMsg = "";
	private float ttScale = 1.5f;
	private int ttIndex = -1;
	private boolean mouseover = false, registered = false;
	private int currentMOIndex = -1, lastMOIndex = -1;
	// private Card currentMouseover = null, lastMouseover = null;
	private float mouseoverTimer = 0.0f;
	private float ttDelay = 0.5f;

	// stacks of effects that need to be removed again
	private Array<IEffect> roundEffects = new Array<IEffect>();
	private Array<IEffect> fightEffects = new Array<IEffect>();
	private Array<IEffect> specialEffect = new Array<IEffect>(); // eventuell eigener typ

	// cards
	private Sprite cardBack = new Sprite(new Texture(Gdx.files.internal("cards/card_back.png")));
	private Card currentCard = null;
	private Array<Card> scenario; // = new Array<Card>(15);

	private int round = 0;

	public PlayingField(OrthographicCamera camera) {
		bg = new Texture(Gdx.files.internal("background_playing.png"));

		this.camera = camera;

		putInBag(new Item(1));
		putInBag(new Item(2));

		ltFontL = ColorRepository.getLtFontL();
		dkFontS = ColorRepository.getDkFontS();
		dkFontL = ColorRepository.getDkFontL();
		dkFontL.setScale(0.9f);

		tooltipSprite = new Sprite(new Texture(
				Gdx.files.internal("tooltip.png")));
		tooltipSprite.setOrigin(0, 0);
		tooltipSprite.setScale(ttScale);

		player = new Player();
		scenario = ScenarioCreator.createScenario();

		textoverSprite.setOriginCenter();
		textoverSprite.setCenter(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		Gdx.app.log("PlayingField", "textover placed at position "
				+ Gdx.graphics.getWidth() / 2 + ", " + Gdx.graphics.getHeight()
				/ 2);

		dispW = (int) camera.viewportWidth; // Gdx.graphics.getWidth();
		dispH = (int) camera.viewportHeight; // Gdx.graphics.getHeight();

		cardX = dispW / 2 - fieldCardSize / 2;
		cardY = dispH / 2 - fieldCardSize / 2;

		cardBack.setPosition(cardX, cardY);
	}

	public void dispose() {
		bg.dispose();
		for (Card c : bag) {
			c.dispose();
		}

		tooltipSprite.getTexture().dispose();
		textoverSprite.getTexture().dispose();
		textoverTex.dispose();
		if (currentCard != null)
			currentCard.dispose();
		cardBack.getTexture().dispose();

		Gdx.app.log("PlayingField", "PlayingField successfully disposed of");
	}

	private Card drawCard() {
		return scenario.pop();
	}

	private void init(SpriteBatch batch) {
		textoverSprite.draw(batch);
		dkFontL.drawWrapped(batch, "Click to begin the round", dispW / 2 - 120,
				dispH / 2 + 40, 240, HAlignment.CENTER);
	}

	private void initTouch(int x, int y, int button) {
		if (button == Buttons.LEFT)
			phase = Phase.BEGIN;
	}

	private void begin(SpriteBatch batch) {
		cardBack.draw(batch);
	}

	private void beginTouch(int x, int y, int button) {
		if (button == Buttons.LEFT) {
			currentCard = drawCard();
			Gdx.app.log("PlayingField", "Scenario popped, " + scenario.size + " remaining");
			if (currentCard != null) {
				currentCard.setPosition(cardX, cardY);
				Gdx.app.log("PlayingField", "Phase set to Drawing");
				phase = Phase.DRAWING;
				textoverSprite.setPosition(0, dispH-130);
				timer = 0.0f;
			}
		}
	}

	private void drawing(SpriteBatch batch) {
		if (currentCard != null) {
			currentCard.render(batch);
			switch(currentCard.getCardType()) {
			case ITEM:
				textoverSprite.draw(batch);
				dkFontS.drawWrapped(batch, "Item " + currentCard.getName() + " drawn", 5,
						dispH-20, 240, HAlignment.CENTER);
				break;
			case CREATURE:
				textoverSprite.draw(batch);
				dkFontS.drawWrapped(batch, "Creature " + currentCard.getName() + " drawn, prepare for a fight!", 5,
						dispH-20, 240, HAlignment.CENTER);
				break;
			case ARTIFACT:
				break;
			default:
				break;
			}
		}
	}

	private void drawingTouch(int x, int y, int button) {
		if (button == Buttons.LEFT) {
			phase = Phase.EXECUTION;
			switch(currentCard.getCardType()) {
			case ITEM:
				
				break;
			case CREATURE:
				break;
			case ARTIFACT:
				break;
			default:
				break;
			}
		}
	}

	private void execution(SpriteBatch batch) {
	
	}

	private void executionTouch(int x, int y, int button) {
	
	}

	private void endround(SpriteBatch batch) {

	}

	private void endroundTouch(int x, int y, int button) {

	}
	
	private void putInBag(Card card) {
		int index = bag.size;
		card.setPosition(index*bagCardSize, 0);
		bag.add(card);
	}

	private void handleMouseover(SpriteBatch batch) {
		Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(touch);
		if (currentCard != null && currentCard.contains(touch.x, touch.y)) {
			currentMOIndex = -2;
			tooltipMsg = currentCard.getDescription();
		} else {
			for (int i = 0; i < bag.size; ++i) {
				if (bag.get(i).contains(touch.x, touch.y)) {
					currentMOIndex = i;
					registered = true;
					tooltipMsg = bag.get(i).getDescription();
				}
			}
			// if over no card
			if (!registered) {
				currentMOIndex = -1;
			}
		}
		if (currentMOIndex != -1 && currentMOIndex == lastMOIndex) {
			mouseoverTimer += Gdx.graphics.getDeltaTime();
			if (mouseoverTimer > ttDelay) {
				showTooltip = true;
			}
		} else {
			mouseoverTimer = 0.0f;
			showTooltip = false;
			tooltipMsg = "";
		}

		lastMOIndex = currentMOIndex;

		if (showTooltip) {
			tooltipSprite.setPosition(touch.x, touch.y);
			tooltipSprite.draw(batch);
			dkFontS.drawWrapped(batch, tooltipMsg, touch.x + 20, touch.y + 128
					* ttScale - 20, 256 * ttScale - 20);
			if (currentMOIndex == -2) {
				if (!currentCard.contains((int) touch.x, (int) touch.y)) {
					showTooltip = false;
					tooltipMsg = "";
					currentMOIndex = -1;
				}
			} else if (!bag.get(currentMOIndex).contains((int) touch.x,
					(int) touch.y)) {
				showTooltip = false;
				tooltipMsg = "";
				currentMOIndex = -1;
			}
		}
		currentMOIndex = -1;
	}

	public void render(SpriteBatch batch) {
		batch.draw(bg, 0, 0);
		for (int i = 0; i < bag.size; ++i) {
			bag.get(i).render(batch);
		}
		ltFontL.draw(batch, debugLog, 0, 300);
		switch (phase) {
		case INIT:
			init(batch);
			break;
		case BEGIN:
			begin(batch);
			break;
		case DRAWING:
			drawing(batch);
			break;
		case EXECUTION:
			execution(batch);
			break;
		case ENDROUND:
			endround(batch);
			break;
		default:
			break;
		}

		dkFontL.drawWrapped(batch, "Health: " + player.getHealth() + "/"
				+ player.getMaxhealth() + " Sanity: " + player.getSanity()
				+ "/" + player.getMaxsanity(), dispW - 220, 80, 210,
				HAlignment.RIGHT);
		dkFontL.drawWrapped(batch, "Power: " + player.getCurrentPower(),
				dispW - 430, 60, 210, HAlignment.RIGHT);

		handleMouseover(batch);
	}

	public void resize(int width, int height) {
	}

	public void touched(int x, int y, int button) {
		if (button == Buttons.RIGHT) {
			if (showTooltip) {
				// remove tooltip
				showTooltip = false;
				tooltipMsg = "";
				ttIndex = -1;
			} else {
				for (int i = 0; i < bag.size; ++i) {
					if (bag.get(i).contains(x, y)) {
						// card at index i right-clicked
						showTooltip = true;
						tooltipMsg = bag.get(i).getDescription();
						ttIndex = i;
						break;
					}
				}
				if (currentCard != null && currentCard.contains(x, y)) {
					showTooltip = true;
					tooltipMsg = currentCard.getDescription();
					ttIndex = -2;
				}
			}
		}
		switch (phase) {
		case INIT:
			initTouch(x, y, button);
			break;
		case BEGIN:
			beginTouch(x, y, button);
			break;
		case DRAWING:
			drawingTouch(x, y, button);
			break;
		case EXECUTION:
			executionTouch(x, y, button);
			break;
		case ENDROUND:
			endroundTouch(x, y, button);
			break;
		default:
			break;
		}
	}

	public void writeDebug(char c) {
		if (debugLog.length() + 1 > 15) {
			debugLog = "";
		}
		debugLog += c;
	}

	public void writeDebug(String str) {
		if (debugLog.length() + str.length() > 15) {
			debugLog = "";
		}
		debugLog += str;
	}

}
