package com.flxkbr.kartham;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Card {
	
	protected CardType type;
	protected String name, description;
	protected int index;
	
	
	Card(CardType type) { this.type = type; }
	Card(String type) {
		if (type.equalsIgnoreCase("creature")) {
			this.type = CardType.CREATURE;
		} else if (type.equalsIgnoreCase("item")) {
			this.type = CardType.ITEM;
		} else if (type.equalsIgnoreCase("artifact")) {
			this.type = CardType.ARTIFACT;
		} else {
			this.type = CardType.EMERGENCE;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getIndex() {
		return index;
	}
	
	abstract void render(SpriteBatch batch, int x, int y);
	abstract void dispose();
	

}
