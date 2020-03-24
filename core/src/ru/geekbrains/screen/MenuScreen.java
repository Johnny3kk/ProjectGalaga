package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 dist;

//    private float rotate;

    @Override
    public void show() {
        super.show();
        img = new Texture("fighter.png");
        pos = new Vector2(0, 0);
        dist = new Vector2();
//        rotate = 0;
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        dist.set(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }

    private void update(float delta) {
            if (pos.x < dist.x) {
                pos.x += dist.x * delta;
            }
            if (pos.x > dist.x){
                pos.x -= dist.x * delta;
            }
            if (pos.y < dist.y) {
                pos.y += dist.y * delta;
            }
            if (pos.y > dist.y) {
                pos.y -= dist.y * delta;
            }
        //        rotate += 1;
    }

    private void draw() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y, 150, 100);
//        batch.draw(new TextureRegion(img), pos.x, pos.y, pos.x, pos.y, 250, 250, 1, 1, rotate);
        batch.end();
    }

}
