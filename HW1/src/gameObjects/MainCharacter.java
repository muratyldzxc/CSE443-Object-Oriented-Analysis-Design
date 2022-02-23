package gameObjects;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import static gameObjects.GameScreen.GROUND;
import static gameObjects.GameScreen.GRAVITY;

import java.awt.Color;
import java.awt.Graphics;

import characterFeatures.JumpBehavior;
import powerups.PowerUp;
import util.GameObject;


public class MainCharacter implements GameObject{
	private JumpBehavior jumpBehavior;
	
	private Rectangle collisionBox;
	private BufferedImage characterImage;
	
	private PowerUp powerUp;
	
	private int lifeCount;
	
	public MainCharacter(Rectangle r, BufferedImage i) {
		collisionBox = r;
		characterImage = i;
	}
	
	
	public PowerUp getPowerUp() {
		return powerUp;
	}


	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}


	public JumpBehavior getJumpBehavior() {
		return jumpBehavior;
	}

	public void setJumpBehaviour(JumpBehavior j) {
		jumpBehavior = j;
	}
	
	/**
	 * Calls current jumpBehaiours jump
	 */
	public void performJump() {
		jumpBehavior.jump(collisionBox);
	}
	    
	/**
	 * Decrements characters life count
	 */
	public void decrementLifeCount() {
		lifeCount--;
	}
	
	public int getLifeCount() {
		return lifeCount;
	}

	public void setLifeCount(int lifeCount) {
		this.lifeCount = lifeCount;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(characterImage, collisionBox.x, collisionBox.y, null);
		g.setColor(Color.black);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
	@Override
	public void update() {
		
		if(!isOnGround()) {
			collisionBox.y += GRAVITY;	
		}
		else {
			collisionBox.y = GROUND-collisionBox.height;
			//System.out.println("height " + height +" yCordinate: " + yCordinate);
		}
	}
	
	/**
	 * Returns true if character is on ground, otherwise false
	 * @return true if character is on ground, otherwise false
	 */
	public boolean isOnGround() {
		if(collisionBox.y + collisionBox.height < GROUND)
			return false;
		else 
			return true;
	}

	@Override
	public Rectangle getCollisionBox() {
		// TODO Auto-generated method stub
		return collisionBox;
	}

	@Override
	public void setCollisionBox(Rectangle r) {
		collisionBox = r;
		
	}
}
