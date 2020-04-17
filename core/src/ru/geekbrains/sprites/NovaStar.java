package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class NovaStar extends Sprite {

    private float height;
    private Rect worldBounds;
    private Vector2 v;

    private float animateInterval = 1.5f;
    private float animateTimer;

    public NovaStar(Texture texture) throws GameException {
        super(new TextureRegion(texture));
        float vx = Rnd.nextFloat(-0.005f, 0.005f);
        float vy = Rnd.nextFloat(-0.05f, -0.08f);
        v = new Vector2(vx, vy);
        animateTimer = Rnd.nextFloat(0, 0.95f);
        height = Rnd.nextFloat(0.005f, 0.025f);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(height);
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        this.pos.set(posX, posY);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        scale += 0.01f;
        animateTimer += delta;
        if (animateTimer >= animateInterval) {
            animateTimer = 0;
            scale = 1;
            pos.set(Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight()), Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop()));
        }
    }
}
