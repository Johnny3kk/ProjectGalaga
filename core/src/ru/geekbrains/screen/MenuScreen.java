package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprites.Background;
import ru.geekbrains.sprites.Flyer;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture fl;
    private Background background;
    private Flyer flyer;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        try {
            background = new Background(bg);
        } catch (GameException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        fl = new Texture("textures/fighter.png");
        try {
            flyer = new Flyer(fl);
        } catch (GameException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
        fl.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
       background.resize(worldBounds);
       flyer.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        flyer.touchDown(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        flyer.update(delta);
    }

    private void draw() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        flyer.draw(batch);
        batch.end();
    }

}