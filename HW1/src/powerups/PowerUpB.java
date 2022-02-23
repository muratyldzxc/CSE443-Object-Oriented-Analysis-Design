package powerups;

import static gameObjects.GameScreen.MOVEMENT_SPEED;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.GameObject;

public class PowerUpB extends PowerUpDecorator implements GameObject{

	private PowerUp powerUp;
	private Rectangle collisionBox;
	
	public PowerUpB(PowerUp p) {
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
			return ", B";
		return powerUp.getDescription() + ", B";
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
			return 5;
		return powerUp.getMultiplier() * 5;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
	}

	@Override
	public void update() {
		collisionBox.x -= MOVEMENT_SPEED;
		
	}
}
