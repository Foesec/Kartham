package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Creature extends Card {
	
	private Texture creaTex;
	private Sprite sprite;
	private CreatureStats stats;
	private CreatureEffect effect;
	
	Creature(int index) {
		super("creature", 0, 0);
		int adjustedIndex = index + 20;
		this.index = adjustedIndex;
		this.name = CardRepository.getNameFromIndex(adjustedIndex);
		this.description = CardRepository.getDescriptionFromIndex(adjustedIndex);
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
		
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void dispose() {
		// TODO Auto-generated method stub
		
	}

}
