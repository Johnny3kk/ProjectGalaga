package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class Exhaust extends Sprite {

    private Rect worldBounds;
    private float animateInterval = 0.5f;
    private float animateTimer;
    public float height;


    public Exhaust(Texture texture) throws GameException {
        super(new TextureRegion(texture));
        pos.set(1.0f, 1.0f);
        animateTimer = Rnd.nextFloat(0, 0.5f);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(height);    }

    @Override
    public void update(float delta) {
        scale += 0.01f;
        animateTimer += delta;
        if (animateTimer >= animateInterval) {
            animateTimer = 0;
            scale = 1;
        }
    }
}
