package powerups;

import static gameObjects.GameScreen.MOVEMENT_SPEED;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.GameObject;

public class PowerUpC extends PowerUpDecorator implements GameObject{
	
	private PowerUp powerUp;
	private Rectangle collisionBox;
	
	public PowerUpC(PowerUp p) {
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
			return ", C";
		return powerUp.getDescription() + ", C";
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
			return 10;
		return powerUp.getMultiplier() * 10;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
	}

	@Override
	public void update() {
		collisionBox.x -= MOVEMENT_SPEED;
		
	}
}
