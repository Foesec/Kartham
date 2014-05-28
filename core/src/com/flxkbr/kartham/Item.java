package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Item extends Card {
	
	enum ItemDuration{
		ONCE, FIGHT, PERMANENT, SPECIAL;
	}
	
	private ItemEffect effect;
	private ItemDuration duration;
	private Texture cardTex;
	private Sprite sprite;
	
	private BitmapFont font = ColorRepository.getDkFontS();
	
	Item(int index, int x, int y){
		super("item", x, y);
		int adjustedIndex = index + 20;
		this.index = adjustedIndex;
		this.name = CardRepository.getNameFromIndex(adjustedIndex);
		this.description = CardRepository.getDescriptionFromIndex(adjustedIndex);
		this.effect = CardRepository.getEffectFromIndex(index);
		this.duration = effect.getItemDuration();
		
		cardTex = new Texture(Gdx.files.internal("cards/card_item.png"));
		sprite = new Sprite(cardTex);
	}

	private Item(CardType type, int x, int y) {
		super(type, x, y);
	}
	
	private Item(String type, int x, int y) {
		super(type, x, y);
	}

	@Override
	void render(SpriteBatch batch) {
		sprite.setPosition(x, y);
		sprite.draw(batch);
		font.drawWrapped(batch, name, x+10, y+44, 128);
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

	@Override
	public boolean contains(int x, int y) {
		return boundingRect.contains(x, y);
	}

}
