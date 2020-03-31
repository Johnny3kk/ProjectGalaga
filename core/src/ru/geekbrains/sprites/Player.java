package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

import static java.awt.event.KeyEvent.VK_LEFT;




public class Player extends Sprite {

    private Vector2 v;
    private boolean pressedLeft;
    private boolean pressedRight;
    private Rect worldBounds;

    public Player(TextureAtlas atlas) throws GameException {
        super(atlas.findRegion("main_ship"));
        regions[frame].setRegion(916, 95, 195, 287 );
        setHeightProportion(0.2f);
        pos.set(0, (-0.5f + this.halfHeight));
        v = new Vector2(-0.01f, 0);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        if (pressedLeft) {
            pos.add(v);
        } else {
            pos.add(0, 0);
        }
        if (pressedRight) {
            pos.mulAdd(v, -1f);
        } else {
            pos.add(0, 0);
        }

        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
        }
    }


    public boolean keyDown(int keycode) {
        if (keycode == 21) {
            pressedLeft = true;
            return false;
        }
        if (keycode == 22) {
            pressedRight = true;
            return false;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == 21) {
            pressedLeft = false;
            return false;
        }
        if (keycode == 22) {
            pressedRight = false;
            return false;
        }
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x < 0) {
            pressedLeft = true;
            return false;
        }
        if (touch.x > 0) {
            pressedRight = true;
            return false;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (touch.x < 0) {
            pressedLeft = false;
            return false;
        }
        if (touch.x > 0) {
            pressedRight = false;
            return false;
        }
        return false;
    }
}
