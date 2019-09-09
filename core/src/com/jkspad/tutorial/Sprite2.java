package com.jkspad.tutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author John Knight
 * Copyright http://www.jkspad.com
 *
 */
public class Sprite2 extends ApplicationAdapter {
	private XNASpriteBatch batch;
	private Texture img;
	private static int NUM_SPRITES = 50;
	private XNASprite[] sprites = new XNASprite[NUM_SPRITES];

	@Override
	public void create () {
		img = new Texture("badlogic.jpg");
		for(int i = 0; i < NUM_SPRITES; i++){
			XNASprite sprite = new XNASprite(img);
			sprites[i] = sprite;
			sprite.setPosition(0, 0);
			sprite.setScale(MathUtils.random(.9f)+.1f);
			sprite.setVelocityX((float) MathUtils.random(50, 300));
			sprite.setVelocityY((float) MathUtils.random(50, 300));
		}
	}

	private void updateSprites(float delta){
		for(int i = 0; i < NUM_SPRITES; i++){
			XNASprite sprite = sprites[i];
			sprite.update(delta);
			float x = sprite.getX();
			float y = sprite.getY();

			// check x axis bounds
			if(x < 0){
				sprite.setX(0);
				sprite.reverseVelocityX();
			}else if(x > Gdx.graphics.getWidth() - sprite.getScaledWidth()){
				sprite.setX(Gdx.graphics.getWidth() - sprite.getScaledWidth());
				sprite.reverseVelocityX();
			}

			// check y axis bounds
			if(y < 0){
				sprite.setY(0);
				sprite.reverseVelocityY();
			}else if(y > Gdx.graphics.getHeight() - sprite.getScaledHeight()){
				sprite.setY(Gdx.graphics.getHeight() - sprite.getScaledHeight());
				sprite.reverseVelocityY();
			}
		}
	}

	private void update(){
		float delta = Gdx.graphics.getDeltaTime();
		updateSprites(delta);
		batch.update();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(int i = 0; i < NUM_SPRITES; i++){
			sprites[i].draw(batch);
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		batch = new XNASpriteBatch(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		img.dispose();
	}
}
