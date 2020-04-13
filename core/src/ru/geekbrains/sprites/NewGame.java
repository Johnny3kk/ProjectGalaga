package ru.geekbrains.sprites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.ProjectGalaga;
import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class NewGame extends ScaledButton {

    private GameScreen screen;

    public NewGame(TextureAtlas atlas, GameScreen screen ) throws GameException {
        super(atlas.findRegion("button_new_game"));
        this.screen = screen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setTop(-0.05f);
    }

    @Override
    public void action() {
        screen.initSprites();
        screen.show();
    }





}
