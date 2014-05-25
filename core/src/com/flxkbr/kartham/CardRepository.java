package com.flxkbr.kartham;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

public class CardRepository {
	
	static private ArrayList<ArrayList<String>> cards = new ArrayList<ArrayList<String>>(4);
	
	static public void init() {
		ArrayList<String> names = new ArrayList<String>(80);
		ArrayList<String> description = new ArrayList<String>(80);
		for (int i = 0; i < 80; ++i) {
			names.add("empty");
			description.add("empty");
		}
		Gdx.app.log("CardRepository", "names and description filled with placeholders");
		
		names.set(0, "Shadow");
		names.set(1, "Crazed Man");
		names.set(2, "Altered");
		names.set(3, "Apostle of Vyl'ek");
		
		names.set(20, "Water");
		names.set(21, "Picture of Someone Dear");
		names.set(22, "Clock");
		names.set(23, "Strange Amulet");
		
		names.set(40, "Engraved Ring");
		names.set(41, "Foreign Book");
		names.set(42, "Modified Pistol");
		names.set(43, "Topaz Shard");
		
		names.set(60, "Visitation");
		names.set(61, "Drawing");
		names.set(62, "Epiphany");
		names.set(64, "Hysteria");
		
		cards.add(names);
		
		// TODO: add descriptions;
		
		cards.add(description);
		
		Gdx.app.log("CardRepository", "CardRepository initialized");
	}
	

	static private int getRangeFromIndex(int i) {
		if (i >= 0 && i <= 19) {
			return 0;
		}
		else if (i <= 39) {
			return 1;
		}
		else if (i <= 59) {
			return 2;
		} 
		else if (i <= 79){
			return 3;
		}
		else return -1;
	}
	
	static private CardType getTypeFromRangeIndex(int i) {
		if (i == 0) {
			return CardType.CREATURE;
		}
		else if (i == 1) {
			return CardType.ITEM;
		}
		else if (i == 2) {
			return CardType.ARTIFACT;
		}
		else if (i == 3) {
			return CardType.EMERGENCE;
		}
		else return null;
	}
	
	static public String getNameFromIndex(int index) {
		if (index >= 0 && index <= 79)
			return cards.get(0).get(index);
		return null;
	}
	
	static public String getDescriptionFromIndex(int index) {
		if (index >= 0 && index <= 79)
			return cards.get(1).get(index);
		return null;
	}
}
