package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

    private Vector2 bullet_position;
    private Sprite sprite_bullet;
    private float speed_bullet = 1000;
    private Vector2 player_position;
    private Sprite player_sprite;

    public Bullet(Texture img_bullet, Player player) {
        this.player_position = player.position;
        sprite_bullet = new Sprite(img_bullet);
        this.player_sprite = player.sprite;
        bullet_position = new Vector2(player.position.x + player.sprite.getWidth()/4, player.position.y);
        sprite_bullet.setSize(20, 50);

    }

    private void Update(float deltaTime) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullet_position = new Vector2(player_position.x + player_sprite.getWidth() / 4, player_position.y);
        }

        bullet_position.y += deltaTime*speed_bullet;
    }

    public void Draw(SpriteBatch batch) {
        Update(Gdx.graphics.getDeltaTime());
        sprite_bullet.setPosition(bullet_position.x, bullet_position.y);
        sprite_bullet.draw(batch);
    }

}
