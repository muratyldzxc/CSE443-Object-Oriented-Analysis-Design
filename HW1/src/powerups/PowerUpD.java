package powerups;

import static gameObjects.GameScreen.MOVEMENT_SPEED;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import characterFeatures.JumpBehavior;
import characterFeatures.JumpHigh;
import characterFeatures.JumpLow;
import util.GameObject;

public class PowerUpD implements GameObject{

	private Rectangle collisionBox;
	
	public PowerUpD() {
		
	}
	
	public String getDescription() {
		return " D ";
	}
	
	public void setCollisionBox(Rectangle r) {
		collisionBox = r;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		
	}

	@Override
	public void update() {
		collisionBox.x -= MOVEMENT_SPEED;
		
	}

	public JumpBehavior changeJumpMod(JumpBehavior j) {
		if(j instanceof JumpHigh)
			return new JumpLow();
		else
			return new JumpHigh();
	}
}
