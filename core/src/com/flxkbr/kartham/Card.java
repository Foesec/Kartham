package com.flxkbr.kartham;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Card {
	
	protected CardType type;
	protected String name, description;
	protected int size;
	protected int index;
	
	
	Card(CardType type) { 
		this.type = type; 
		size = 128;
	}
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
		size = 128;
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
	
	public int getSize() {
		return size;
	}
	
	abstract public void setSize(int size);
	
	
	abstract void render(SpriteBatch batch, int x, int y);
	abstract void dispose();
	

}
