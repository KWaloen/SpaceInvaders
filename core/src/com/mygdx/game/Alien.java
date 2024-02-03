package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Alien {
    private Vector2 alien_position;
    private Sprite sprite;
    private Boolean Alive = true;
    Alien[] alienList;
    int NumWidth_aliens = 11;
    int NumHeight_aliens = 5;
    public int alienHordeDimension = NumHeight_aliens * NumWidth_aliens;
    int spacing_aliens = 50;
    Texture alien_img;

    public Alien(Vector2 position, Texture alien_img) {
        alien_position = position;
        sprite = new Sprite(alien_img);
        sprite.setSize(50, 50);
    }



    public void Draw (SpriteBatch batch) {
        sprite.setPosition(alien_position.x, alien_position.y);
        sprite.draw(batch);

    }
}
