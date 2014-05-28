package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class PlayingFieldInputProcessor implements InputProcessor {
	PlayingField pf;
	
	private boolean klickDown = false;
	
	public PlayingFieldInputProcessor(PlayingField pf) {
		this.pf = pf;
	}

	@Override
	public boolean keyDown(int keycode) {
		// debug only
		if (keycode == Keys.ESCAPE) {
			Gdx.app.exit();
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		pf.writeDebug(character);
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		pf.touched(screenX, Gdx.graphics.getHeight()-screenY, button);
		Gdx.app.log("InputProcessor", "Click registered at: " + screenX + " " + screenY + ", " + button);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
