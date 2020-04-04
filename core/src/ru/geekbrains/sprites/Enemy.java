package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class Enemy extends Sprite {

    private Rect worldBounds;
    private Vector2 v;
    private Vector2 pos0;

    public Enemy() {
        regions = new TextureRegion[1];
        v = new Vector2(0, -0.001f);
        pos.set(Rnd.nextFloat(-0.4f, 0.4f), 0.5f);

    }

    public void set(
            TextureRegion region,
            float height,
            Rect worldBounds
    ) {
        this.regions[0] = region;
        setHeightProportion(height);
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        pos.add(v);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }
}
