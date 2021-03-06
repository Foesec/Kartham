package com.flxkbr.kartham.desktop;

import java.awt.DisplayMode;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.flxkbr.kartham.Kartham;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width = 854;
		cfg.height = 480;
		//cfg.resizable = false;
		new LwjglApplication(new Kartham(), cfg);
	}
}
