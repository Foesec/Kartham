package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class PlayingField {
	
	enum Phase { INIT, BEGIN, DRAWING, EXECUTION, ENDROUND }
	
	private Phase phase = Phase.INIT;
	
	private Array<Card> bag = new Array<Card>();
	private Texture bg;
	private int bagCardSize = 128;
	private String debugLog = "";
	private BitmapFont lFont, sFont;
	private Sprite tooltipSprite;
	
	// player
	private Player player;
	
	// tooltip handling
	private boolean showTooltip = false;
	private String tooltipMsg = "";
	private float ttScale = 1.5f;
	private int ttIndex = -1;
	
	// stacks of effects that need to be removed again
	private Array<IEffect> roundEffects = new Array<IEffect>();
	private Array<IEffect> fightEffects = new Array<IEffect>();
	private Array<IEffect> specialEffect = new Array<IEffect>(); // eventuell eigener Typ
	
	// faggotty
	private Array<Card> scenario = new Array<Card>(15);
	
	private int round = 0;
	
	public PlayingField() {
		bg = new Texture(Gdx.files.internal("background_playing.png"));
		
		bag.add(new Item(0, 0, 0));
		bag.add(new Item(1, 128, 0));
		
		lFont = ColorRepository.getLtFontL();
		sFont = ColorRepository.getDkFontS();
		//font.setColor(ColorRepository.beige);
		
		tooltipSprite = new Sprite(new Texture(Gdx.files.internal("tooltip.png")));
		tooltipSprite.setScale(ttScale);
		
		player = new Player();
		scenario = ScenarioCreator.createScenario();
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(bg, 0, 0);
		for (int i = 0; i < bag.size; ++i) {
			bag.get(i).render(batch);
		}
		lFont.draw(batch, debugLog, 0, 300);
		switch(phase) {
		case INIT:
			break;
		case BEGIN:
			break;
		case DRAWING:
			break;
		case EXECUTION:
			break;
		case ENDROUND:
			break;
		default:
			break;
		}
		
		lFont.drawWrapped(batch, 
						  "Health: " + player.getHealth() + "/" + player.getMaxhealth() + " Sanity: " + player.getSanity() + "/" + player.getMaxsanity() ,
						  Gdx.graphics.getWidth() - 215, 
						  80, 
						  210,
						  HAlignment.RIGHT);
		
		if (showTooltip) {
			int mx = Gdx.input.getX();
			int my = Gdx.graphics.getHeight() - Gdx.input.getY();
			tooltipSprite.setPosition(mx, my);
			tooltipSprite.setOrigin(0, 0);
			tooltipSprite.draw(batch);
			sFont.drawWrapped(batch, tooltipMsg, mx+15, my+128*ttScale-15, 256*ttScale-20);
			if (!bag.get(ttIndex).contains(mx, my)) {
				// mouse left card
				showTooltip = false;
				tooltipMsg = "";
				ttIndex = -1;
			}
		}
	}
	
	private void init(SpriteBatch batch)  {
		
	}
	
	private void initTouch() {
		
	}
	
	private void begin(SpriteBatch batch) {
		
	}
	
	private void beginTouch() {
		
	}
	
	private void drawing(SpriteBatch batch) {
		
	}
	
	private void drawingTouch() {
		
	}
	
	private void execution(SpriteBatch batch) {
		
	}
	
	private void executionTouch() {
		
	}
	
	private void endround(SpriteBatch batch) {
		
	}
	
	private void endroundTouch() {
		
	}
	
	public void dispose() {
		bg.dispose();
		for (Card c : bag) {
			c.dispose();
		}
		Gdx.app.log("PlayingField", "PlayingField successfully disposed of");
		
		tooltipSprite.getTexture().dispose();
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
	
	public void touched(int x, int y, int button) {
		Gdx.app.log("PlayingField", "Clicked " + x + " " + y + " with button: " + button);
		if (button == Buttons.RIGHT) {
			if (showTooltip) {
				// remove tooltip
				showTooltip = false;
				tooltipMsg = "";
				ttIndex = -1;
			} else {
				for (int i = 0; i<bag.size; ++i) {
					if (bag.get(i).contains(x,  y)) {
						// card at index i right-clicked
						showTooltip = true;
						tooltipMsg = bag.get(i).getDescription();
						ttIndex = i;
					}
				}
			}
		}
		switch(phase) {
		case INIT:
			break;
		case BEGIN:
			break;
		case DRAWING:
			break;
		case EXECUTION:
			break;
		case ENDROUND:
			break;
		default:
			break;
		}
	}

}
