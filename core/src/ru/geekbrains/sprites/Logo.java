package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

public class Logo extends Sprite {

    private static final float TOP_POS = 0.3f;
    private final Vector2 v = new Vector2(0, -0.001f);

    public Logo(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.4f);
        setBottom(0.65f);
    }

    @Override
    public void update(float delta) {
        if (getTop() > TOP_POS ) {
            pos.add(v);
        }
    }
}
