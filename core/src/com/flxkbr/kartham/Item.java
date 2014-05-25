package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item extends Card {
	
	enum ItemEffect{
		HEALTH, POWER, SANITY, MULTIPLE;
	}
	
	enum ItemDuration{
		ROUND, FIGHT, PERMANENT, SPECIAL;
	}
	
	private ItemEffect effect;
	private ItemDuration duration;
	private Texture cardTex;
	private Sprite sprite;
	
	Item(int index){
		super("item");
		this.index = index;
		this.name = CardRepository.getNameFromIndex(index);
		this.description = CardRepository.getDescriptionFromIndex(index);
		this.effect = CardRepository.getEffectFromIndex(index);
		this.duration = CardRepository.getDurationFromIndex(index);
		cardTex = new Texture(Gdx.files.internal("cards/card_item.png"));
		sprite = new Sprite(cardTex);
	}

	private Item(CardType type) {
		super(type);
	}
	
	private Item(String type) {
		super(type);
	}

	@Override
	void render(SpriteBatch batch, int x, int y) {
		sprite.setPosition(x, y);
		sprite.draw(batch);
	}

	@Override
	void dispose() {
		cardTex.dispose();
	}
	
	@Override
	public void setSize(int size) {
		this.size = size;
		sprite.setSize(size, size);
	}

}
