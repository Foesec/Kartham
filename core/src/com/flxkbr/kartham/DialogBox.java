package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DialogBox {

	private String message;
	private String leftButton, rightButton;
	private InputProcessor previousIP;
	private Pixmap dialog;
	private final int x = Gdx.graphics.getWidth() / 2;
	private final int y = Gdx.graphics.getHeight() / 2;
	
	public DialogBox(String msg, String leftButton, String rightButton) {
		message = msg;
		dialog = new Pixmap(200, 100, Format.RGBA8888);
		dialog.setColor(ColorRepository.dkGrey);
		dialog.fill();
		this.leftButton = leftButton;
		this.rightButton = rightButton;
		previousIP = Gdx.input.getInputProcessor();
		Gdx.input.setInputProcessor(new DialogInputProcessor(this));
	}
	
	public DialogBox(String msg, String button) {
		this(msg, button, "");
	}
	
	public void touchDown(int x, int y) {
		
	}
	
	private void leftClicked() {
		
	}
	
	private void rightClicked() {
		
	}
	
	public void render(SpriteBatch batch) {
		
	}
	
	public void dispose() {
		Gdx.input.setInputProcessor(previousIP);
	}
	
	class DialogInputProcessor extends InputAdapter {
		private DialogBox dialog;
		
		public DialogInputProcessor(DialogBox db) {
			dialog = db;
		}
		
		public boolean touchDown(int x, int y, int pointer, int button) {			
			return false;
		}
		
		public boolean touchUp(int x, int y, int pointer, int button) {
			return false;
		}
	}
}
