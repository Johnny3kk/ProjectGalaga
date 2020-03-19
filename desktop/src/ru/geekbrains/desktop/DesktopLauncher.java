package ru.geekbrains.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.geekbrains.ProjectGalaga;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1030;
		config.height = 640;
		config.x = 150;
		config.y = 50;
		new LwjglApplication(new ProjectGalaga(), config);
	}
}
