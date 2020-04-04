package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.sprites.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    @Override
    protected Enemy newObject() {
        return new Enemy();
    }
}
