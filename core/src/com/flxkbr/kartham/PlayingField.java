package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class PlayingField {
	
	enum Phase { BEGIN, DRAWING, REACT, EXECUTE, ENDROUND }
	
	private Array<Card> bag = new Array<Card>();
	private Texture bg;
	private int bagCardSize = 128;
	private String debugLog = "";
	private BitmapFont font;
	
	public PlayingField() {
		bg = new Texture(Gdx.files.internal("background_playing.png"));
		
		bag.add(new Item(0));
		bag.add(new Item(1));
		
		font = new BitmapFont(Gdx.files.internal("fonts/averia.fnt"), Gdx.files.internal("fonts/averia.png"), false);
		font.setColor(ColorRepository.beige);
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(bg, 0, 0);
		for (int i = 0; i < bag.size; ++i) {
			bag.get(i).render(batch, i*bagCardSize, 0);
		}
		font.draw(batch, debugLog, 0, 300);
	}
	
	public void dispose() {
		bg.dispose();
		for (Card c : bag) {
			c.dispose();
		}
		Gdx.app.log("PlayingField", "PlayingField successfully disposed of");
	}
	
	public void writeDebug(char c) {
		if (debugLog.length() + 1 > 15) {
			debugLog = "";
		}
		debugLog += c;
	}
	
	public void writeDebug(String str) {
		if (debugLog.length() + str.length() > 15) {
			debugLog = "";
		}
		debugLog += str;
	}
	
	public void touched(int x, int y, int button) {
		bag.add(new Item(3));
	}

}
