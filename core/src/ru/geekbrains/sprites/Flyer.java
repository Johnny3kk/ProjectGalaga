package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

public class Flyer extends Sprite {



    public Flyer(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    private static final float V_LEN = 0.015f;

    private Vector2 v = new Vector2();
    private Vector2 tmp1 = new Vector2();
    private Vector2 tmp2 = new Vector2();


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);

    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        tmp1.set(touch);
        v.set(touch.sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public void update(float delta) {
        tmp2.set(tmp1);
        float remainingDistance = (tmp2.sub(pos)).len();
        if (remainingDistance > V_LEN) {
            pos.add(v);
        } else {
            v.setZero();
            pos.set(tmp1);
        }

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
}
