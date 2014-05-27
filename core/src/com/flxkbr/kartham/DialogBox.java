package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class DialogBox {

	private String message;
	private InputProcessor previousIP;
	
	public DialogBox(String msg) {
		message = msg;
		previousIP = Gdx.input.getInputProcessor();
		Gdx.input.setInputProcessor(new DialogInputProcessor(this));
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
