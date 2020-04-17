package ru.geekbrains.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Ship;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;

public class Enemy extends Ship {

    private final Vector2 descentV;
    private Texture exen;
    private Exhaust exhaust;

    public Enemy(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        v = new Vector2();
        v0 = new Vector2();
        bulletV = new Vector2();
        bulletPos = new Vector2();
        descentV = new Vector2(0, -0.3f);
        initEx();

    }

    public void initEx() {
        try{
            exen = new Texture("textures/exhaust2.png");
            exhaust = new Exhaust(exen);
        } catch (GameException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(float delta) {
        if (exhaust.getHeight() <= 0.02){
            exhaust.pos.set(pos.x, pos.y + getHalfHeight() / 2);
        } else {
            exhaust.pos.set(pos.x, pos.y + halfHeight + exhaust.getHalfHeight());
        }
        bulletPos.set(pos.x, pos.y - getHalfHeight());
        if (getTop() <= worldBounds.getTop()) {
            v.set(v0);
            autoShoot(delta);
        }
        if (getBottom() <= worldBounds.getBottom()) {
            destroy();
        }
        exhaust.update(delta);
        super.update(delta);
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int damage,
            float reloadInterval,
            Sound shootSound,
            int hp,
            float height,
            float exHeight
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = reloadInterval;
        this.shootSound = shootSound;
        this.hp = hp;
        this.v.set(descentV);
        exhaust.height = exHeight;
        exhaust.setHeightProportion(exHeight);
        setHeightProportion(height);
    }

    public boolean isBulletCollision(Rect bullet) {
        return !(bullet.getRight() < getLeft()
                || bullet.getLeft() > getRight()
                || bullet.getBottom() > getTop()
                || bullet.getTop() < pos.y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (!this.isDestroyed()) {
            exhaust.draw(batch);
        }
    }
}