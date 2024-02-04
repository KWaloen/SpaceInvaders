package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture player_img;
    Player player;
    Bullet bullet;
    Texture bullet_img;
    Texture alien_img;
    Alien alien;
    Alien[] alienList;
    int NumWidth_aliens = 11;
    int NumHeight_aliens = 5;
    int alienHordeDimension = NumHeight_aliens * NumWidth_aliens;
    int spacing_aliens = 50;


    @Override
    public void create() {
        batch = new SpriteBatch();
        drawPlayer();
        drawBullet();
        drawAliens();
    }

    private void drawPlayer() {
        player_img = new Texture("spaceship.png");
        player = new Player(player_img);
    }

    private void drawBullet() {
        bullet_img = new Texture("bullet.png");
        bullet = new Bullet(bullet_img, player);
    }

    private void drawAliens() {
        alien_img = new Texture("alien.png");
        drawAlienHorde();
    }

    private void alienRender() {

        for (int i = 0; i < alienHordeDimension; i++) {
            if (bullet.sprite_bullet.getBoundingRectangle().overlaps(alienList[i].sprite.getBoundingRectangle()) && alienList[i].Alive) {
                alienList[i].Alive = false;
                bullet.breakBullet();

            }
        }
        for (int i = 0; i < alienHordeDimension; i++) {
            if (alienList[i].Alive) {
                alienList[i].Draw(batch);
            }
        }
    }

    public void drawAlienHorde() {
        int i = 0;
        alienList = new Alien[alienHordeDimension];

        for (int y = 0; y < NumHeight_aliens; y++) {
            for (int x = 0; x < NumWidth_aliens; x++) {
                Vector2 position = new Vector2(x * spacing_aliens, y * spacing_aliens);
                position.x += 250;
                position.y += 500;
                alienList[i] = new Alien(position, alien_img);
                i++;
            }
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        player.Draw(batch);
        bullet.Draw(batch);
        alienRender();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player_img.dispose();
    }
}
