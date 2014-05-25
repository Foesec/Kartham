package com.flxkbr.kartham;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Kartham implements ApplicationListener {
	private SpriteBatch batch;
	//private Item myitem;
	private PlayingField pf;
	private BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		CardRepository.init();
		//myitem = new Item(0);
		//Gdx.app.log("Item", "Item " + myitem.getIndex() + " created: " + myitem.getName() + ", " + myitem.getDescription());
		
		pf = new PlayingField();
		
		PlayingFieldInputProcessor input = new PlayingFieldInputProcessor(pf);
		Gdx.input.setInputProcessor(input);
		font = new BitmapFont(Gdx.files.internal("fonts/averia.fnt"), Gdx.files.internal("fonts/averia.png"), false);
		font.setColor(ColorRepository.beige);
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
		//myitem.render(batch, 0, 0);
		//myitem.render(batch, 128, 0);
		font.draw(batch, "Here goes nothing", 100, 300);
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
		// TODO Auto-generated method stub
		//myitem.dispose();
		batch.dispose();
		font.dispose();
		pf.dispose();
	}

}
