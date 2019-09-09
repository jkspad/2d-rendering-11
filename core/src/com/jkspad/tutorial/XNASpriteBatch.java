package com.jkspad.tutorial;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author John Knight
 * Copyright http://www.jkspad.com
 *
 */
public class XNASpriteBatch extends SpriteBatch {

	private final OrthographicCamera camera;
	
	public XNASpriteBatch(float viewportWidth, float viewportHeight) {
		super();
	
		camera = new OrthographicCamera(viewportWidth, viewportHeight);
		camera.setToOrtho(true, viewportWidth, viewportHeight);
	}

	public void update(){
		camera.update();
		setProjectionMatrix(camera.combined);	// note use of combined,  NOT projection
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
}
