package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class PlayingField {
	
	private Array<Card> bag;
	private Texture bg;
	
	public PlayingField() {
		bg = new Texture(Gdx.files.internal("background_playing.png"));
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(bg, 0, 0);
	}
	
	public void dispose() {
		bg.dispose();
	}

}
