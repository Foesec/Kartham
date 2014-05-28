package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Creature extends Card {
	
	private Texture creaTex;
	private Sprite sprite;
	private CreatureStats stats;
	private CreatureEffect effect;
	private BitmapFont font = ColorRepository.getDkFontS();
	
	Creature(int index) {
		super("creature", 0, 0);
		int adjustedIndex = index; // creatures start at 0
		this.index = adjustedIndex;
		this.name = CardRepository.getNameFromIndex(adjustedIndex);
		this.description = CardRepository.getDescriptionFromIndex(adjustedIndex);
		this.stats = CardRepository.getCreatureStatFromIndex(index);
		this.effect = CardRepository.getCreatureEffectFromIndex(index);
		//this.effect = CardRepository.getEffectFromIndex(index);
		//this.duration = effect.getItemDuration();
		
		creaTex = new Texture(Gdx.files.internal("cards/card_creature.png"));
		sprite = new Sprite(creaTex);
	}

//	Creature(CardType type, int x, int y) {
//		super(type, x, y);
//	}
//	
//	Creature(String type, int x, int y) {
//		super(type, x, y);
//	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		this.size = size;
		sprite.setSize(size, size);
		boundingRect.setSize(size);
	}

	@Override
	public boolean contains(int x, int y) {
		return boundingRect.contains(x, y);
	}

	@Override
	void render(SpriteBatch batch) {
		sprite.draw(batch);
		font.drawWrapped(batch, name, x+10, y+44, 128);
	}

	@Override
	void dispose() {
		// TODO Auto-generated method stub
		
	}

}
