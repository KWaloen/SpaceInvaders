package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Alien {
    private Vector2 alien_position;
    public Sprite sprite;
    public Boolean Alive = true;

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
