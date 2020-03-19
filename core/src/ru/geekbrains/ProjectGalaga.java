package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProjectGalaga extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	Sprite backSprite;
	int WIDTH = 1030;
	int HEIGHT = 640;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background = new Texture("WDS02.png");
		backSprite = new Sprite(background);
		backSprite.setSize(WIDTH, HEIGHT);
		backSprite.setPosition(0f, 0f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backSprite.draw(batch);
		batch.draw(img, 270, 400, 120f, 120f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		background.dispose();
	}
}
