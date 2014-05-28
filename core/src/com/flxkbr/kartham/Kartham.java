package com.flxkbr.kartham;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kartham implements ApplicationListener {
	private SpriteBatch batch;

	private PlayingField pf;

	@Override
	public void create() {
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		CardRepository.init();
		ColorRepository.init();
		
		pf = new PlayingField();
		
		PlayingFieldInputProcessor input = new PlayingFieldInputProcessor(pf);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		pf.render(batch);
		batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		pf.dispose();
		batch.dispose();
		ColorRepository.dispose();
	}

}
