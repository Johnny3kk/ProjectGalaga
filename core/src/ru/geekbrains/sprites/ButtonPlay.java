package ru.geekbrains.sprites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class ButtonPlay extends ScaledButton {

    private final Game game;
    private static final float BOTTOM_POS = -0.45f;
    private final Vector2 v = new Vector2(0, 0.001f);


    public ButtonPlay(TextureAtlas atlas, Game game) throws GameException {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setLeft(-0.3f);
        setTop(-0.65f);
    }

    @Override
    public void update(float delta) {
        if (getBottom() < BOTTOM_POS ) {
            pos.add(v);
        }
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}