package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    public Vector2 position;
    public Sprite sprite;
    private int playerSpeed = 300;

    public Player(Texture img) {
        sprite = new Sprite(img);
        position = new Vector2((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 25);
        sprite.setSize(40, 40);
    }

    public void Update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x > 0) {
            position.x -= deltaTime*playerSpeed;
            System.out.println("x " + position.x);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x < Gdx.graphics.getWidth() - sprite.getWidth()) {
            position.x += deltaTime*playerSpeed;
            System.out.println("x " + position.x);
        }
    }

    public void Draw(SpriteBatch batch) {
        Update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);

    }

}
