package powerups;

import java.awt.Graphics;
import java.awt.Rectangle;

import util.GameObject;

import static gameObjects.GameScreen.MOVEMENT_SPEED;

import java.awt.Color;

public class PowerUpA extends PowerUpDecorator implements GameObject{
	
	private PowerUp powerUp;
	private Rectangle collisionBox;
	
	public PowerUpA(PowerUp p) {
		powerUp = p;
	}
	
	
	
	public PowerUp getPowerUp() {
		return powerUp;
	}



	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}



	public String getDescription() {
		if(powerUp == null)
			return ", A";
		return powerUp.getDescription() + ", A";
	}
	
	public void setCollisionBox(Rectangle r) {
		collisionBox = r;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	@Override
	public int getMultiplier() {
		if(powerUp == null)
			return 2;
		return powerUp.getMultiplier() * 2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
	}

	@Override
	public void update() {
		collisionBox.x -= MOVEMENT_SPEED;
		
	}


}
