package com.flxkbr.kartham;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.flxkbr.kartham.Item.ItemDuration;

public class CardRepository {
	
	static private ArrayList<ArrayList<String>> cards = new ArrayList<ArrayList<String>>(4);
	static private Array<ItemEffect> itemEffects = new Array<ItemEffect>(20);
	
	static public void init() {
		setupCards();
		setupItems();
		
		Gdx.app.log("CardRepository", "CardRepository initialized");
	}
	
	static private void setupCards() {
		ArrayList<String> names = new ArrayList<String>(80);
		ArrayList<String> description = new ArrayList<String>(80);
		for (int i = 0; i < 80; ++i) {
			names.add("empty");
			description.add("empty");
		}
		
		names.set(0, "Shadow");
		names.set(1, "Crazed Man");
		names.set(2, "Altered");
		names.set(3, "Apostle of Vyl'ek");
		
		names.set(20, "Water");
		names.set(21, "Picture of Someone Dear");
		names.set(22, "Pocketwatch");
		names.set(23, "Strange Brew");
		
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
		description.set(0, "It has been following you for a while now");
		description.set(1, "The proximity to sources of Old may have severe consequences to the minds of some");
		description.set(2, "Some feel irresitably drawn sources of Old, others seek them out actively");
		description.set(3, "Even unreal beings need representants in this plane of existence");
		
		description.set(20, "Clear, unremarkable Water. Gives you a moment of repose (HP + 2)");
		description.set(21, "The reminder of someone close to you gives you sudden resolve (P + 1 until next Fight)");
		description.set(22, "The innocuous, yet assertive clicking of the watch sobers your mind (S + 1)");
		description.set(23, "A viscous fluid of many colours. Strengthens your mind and health lastingly (MHP + 1, MS + 1)");
		
		cards.add(description);
	}
	
	static private void setupItems() {
		for (int i = 0; i < 20; ++i) {
			itemEffects.add(null);
		}
		ItemEffect ie = new ItemEffect(2, 0, 0, 0, 0, 0, ItemDuration.ONCE);
		itemEffects.set(0,ie);
		ItemEffect ie2 = new ItemEffect(0, 0, 1, 0, 0, 0, ItemDuration.FIGHT);
		itemEffects.set(1, ie2);
		ItemEffect ie3 = new ItemEffect(2, 0, 0, 0, 0, 0, ItemDuration.ONCE);
		itemEffects.set(2, ie3);
		ItemEffect ie4 = new ItemEffect(2, 0, 0, 0, 0, 0, ItemDuration.PERMANENT);
		itemEffects.set(3, ie4);
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
	
	static public CardType getTypeFromRangeIndex(int i) {
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
	
	static public ItemEffect getEffectFromIndex(int index) {
		if (index > 19)
			return null;
		return itemEffects.get(index);
	}
	
	static public void dispose() {
		Gdx.app.log("CardRepository", "successfully disposed of");
	}

}
