package com.flxkbr.kartham;

public enum CardType {
	CREATURE("creature"),
	ITEM("item"),
	ARTIFACT("artifact"),
	EMERGENCE("emergence");

	private final String type;
	
	CardType(String type) {
		this.type = type;
	}
	
	public String type() { return type; }
}
