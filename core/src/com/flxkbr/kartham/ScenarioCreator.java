package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class ScenarioCreator {
	
	private static int items = 3;
	private static int creatures = 4;
	private static int artifacts = 3;
	private static int emergences = 3;
	private static int scenarioSize = 15;
	private static String debug = "";

	// create random scenario
	public static Array<Card> createScenario() {
		Array<Card> scenario = new Array<Card>(15);
		debug = "";
		for (int i = 0; i<scenarioSize/2+1; ++i) {
			scenario.add(getRandomItem());
			debug += scenario.get(i).getName() + ", ";
		}
		// careful, only works with uneven size
		for (int i = 0; i<scenarioSize/2; ++i) {
			scenario.add(getRandomCreature());
		}
		
		//Gdx.app.log("ScenarioCreator", "Unshuffled Scenario: " + debug);
		debug = "";
		// TODO: insert other cards
		scenario.shuffle();
		//Gdx.app.log("ScenarioCreator", "Shuffled once scenario: " + debug);
		scenario.shuffle();
		
		return scenario;
	}
	
	private static Item getRandomItem() {
		int rand = (int)Math.round(Math.random()*3);
		return new Item(rand);
	}
	
	private static Creature getRandomCreature() {
		int rand = (int)Math.round(Math.random()*3);
		return new Creature(rand);
	}
	/*
	private static Artifact getRandomArtifact() {
		
	}
	
	private static Emergence getRandomEmergence() {
		
	} */
}
