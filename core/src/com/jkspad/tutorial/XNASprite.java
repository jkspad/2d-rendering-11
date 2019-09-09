package com.jkspad.tutorial;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * @author John Knight
 * Copyright http://www.jkspad.com
 *
 */
public class XNASprite extends Sprite {

	private Vector2 velocity = new Vector2();
	
	public XNASprite(Texture texture) {
		super(texture);
		xnaInit();
	}
	
	private void xnaInit(){
		flip(false, true);
	}

	public void update(float delta){
		setX( Math.round(getX() + delta * velocity.x)); 
		setY( Math.round(getY() + delta * velocity.y)); 
	}

	
	@Override
	public void setScale(float scaleXY) {
		setOrigin(0, 0);
		super.setScale(scaleXY);
	}
	
	public float getVelocityX(){
		return velocity.x;
	}
	
	public float getVelocityY(){
		return velocity.y;
	}

	public void setVelocityX(float x){
		velocity.x = x;
	}
	
	public void setVelocityY(float y){
		velocity.y = y;
	}

	public void reverseVelocityX(){
		velocity.x *= -1;
	}
	
	public void reverseVelocityY(){
		velocity.y *= -1;
	}
	
	public float getScaledWidth(){
		return getWidth() * getScaleX();
	}

	public float getScaledHeight(){
		return getHeight() * getScaleY();
	}
}
