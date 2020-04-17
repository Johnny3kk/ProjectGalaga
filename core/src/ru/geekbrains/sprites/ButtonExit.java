package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

public class ButtonExit extends ScaledButton {

    private static final float BOTTOM_POS = -0.45f;
    private final Vector2 v = new Vector2(0, 0.001f);


    public ButtonExit(TextureAtlas atlas) throws GameException {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setRight(0.3f);
        setTop(-0.7f);
    }

    @Override
    public void update(float delta) {
        if (getBottom() < BOTTOM_POS ) {
            pos.add(v);
        }
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}