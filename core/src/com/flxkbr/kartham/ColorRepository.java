package com.flxkbr.kartham;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ColorRepository {
	
	public static final Color dkBrown = new Color(112f/255f, 48f/255f, 48f/255f, 1.0f);
	public static final Color ltBrown = new Color(199f/255f, 121f/255f, 102f/255f, 1.0f);
	public static final Color dkGrey = new Color(47f/255f, 52f/255f, 59f/255f, 1.0f);
	public static final Color ltGrey = new Color(126f/255f, 130f/255f, 122f/255f, 1.0f);
	public static final Color beige = new Color(227f/255f, 205f/255f, 164f/255f, 1.0f);
	
	public static final BitmapFont font = new BitmapFont(
			Gdx.files.internal("fonts/averia.fnt"), Gdx.files.internal("fonts/averia.png"), false);


}
