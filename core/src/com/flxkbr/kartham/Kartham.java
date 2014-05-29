package com.flxkbr.kartham;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kartham implements ApplicationListener {
	private SpriteBatch batch;

	private PlayingField pf;
	
	private OrthographicCamera camera;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 854, 480);
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		CardRepository.init();
		ColorRepository.init();
		
		pf = new PlayingField(camera);
		
		PlayingFieldInputProcessor input = new PlayingFieldInputProcessor(pf, camera);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		pf.resize(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		pf.render(batch);
		batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Gdx.app.log("Kartham", "Game Paused");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Gdx.app.log("Kartham", "Game resumed");
	}

	@Override
	public void dispose() {
		pf.dispose();
		batch.dispose();
		ColorRepository.dispose();
		Gdx.app.log("Kartham", "Game exited successfully");
	}

}
