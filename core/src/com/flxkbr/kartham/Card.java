package com.flxkbr.kartham;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Card {
	
	protected CardType type;
	protected String name, description;
	protected int size;
	protected int index;
	protected int x, y;
	protected Rectangle boundingRect;
	
	
	Card(CardType type, int x, int y) { 
		this.type = type; 
		this.x = x;
		this.y = y;
		size = 128;
		boundingRect = new Rectangle(x, y, size, size);
	}
	Card(String type, int x, int y) {
		if (type.equalsIgnoreCase("creature")) {
			this.type = CardType.CREATURE;
		} else if (type.equalsIgnoreCase("item")) {
			this.type = CardType.ITEM;
		} else if (type.equalsIgnoreCase("artifact")) {
			this.type = CardType.ARTIFACT;
		} else {
			this.type = CardType.EMERGENCE;
		}
		this.x = x;
		this.y = y;
		size = 128;
		boundingRect = new Rectangle(x, y, size, size);
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public abstract void setPosition(int x, int y);
	
	public Rectangle getRect() {
		return boundingRect;
	}
	
	public CardType getCardType() {
		return type;
	}
	
	
	public abstract void setSize(int size);
	public abstract boolean contains(int x, int y);
	
	abstract void render(SpriteBatch batch);
	
	abstract void dispose();
	

}
