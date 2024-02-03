package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture player_img;
	Player player;
	Bullet bullet;
	Texture bullet_img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player_img = new Texture("spaceship.png");
		bullet_img = new Texture("bullet.png");
		player = new Player(player_img);
		bullet = new Bullet(bullet_img, player);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();
		player.Draw(batch);
		bullet.Draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player_img.dispose();
	}
}
