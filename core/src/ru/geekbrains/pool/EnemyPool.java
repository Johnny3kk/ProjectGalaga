package ru.geekbrains.pool;

import com.badlogic.gdx.graphics.Texture;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprites.Enemy;
import ru.geekbrains.sprites.Exhaust;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected Enemy newObject() {
            return new Enemy(bulletPool, explosionPool, worldBounds);
    }

}