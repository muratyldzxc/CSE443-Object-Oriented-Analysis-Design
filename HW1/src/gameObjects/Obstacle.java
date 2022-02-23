package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.GameObject;
import static gameObjects.GameScreen.MOVEMENT_SPEED;

public class Obstacle implements GameObject{

	private Rectangle collisionBox;
	private BufferedImage obstacleImage;
	
	
	/**
	 * A box to collide with character when character is over the obstacle
	 */
	private Rectangle pointBox;
	
	public Obstacle(Rectangle r, BufferedImage i) {
		obstacleImage = i;
		collisionBox = r;
		setPointBox(new Rectangle(r.x+5, 0, r.width-5, GameScreen.SCREEN_HEIGHT - obstacleImage.getHeight() - 15));
	}
	
	
	
	public Rectangle getPointBox() {
		return pointBox;
	}



	public void setPointBox(Rectangle pointBox) {
		this.pointBox = pointBox;
	}

	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawImage(obstacleImage, collisionBox.x, collisionBox.y, null);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}

	@Override
	public Rectangle getCollisionBox() {
		// TODO Auto-generated method stub
		return collisionBox;
	}

	@Override
	public void setCollisionBox(Rectangle r) {
		collisionBox = r;
		setPointBox(new Rectangle(r.x+5, 0, r.width-5, GameScreen.SCREEN_HEIGHT - obstacleImage.getHeight() - 15));
	}

	@Override
	public void update() {
		collisionBox.x -= MOVEMENT_SPEED;
		if(pointBox != null)
			setPointBox(new Rectangle(collisionBox.x+5, 0, collisionBox.width-10, GameScreen.SCREEN_HEIGHT - obstacleImage.getHeight() - 15));
	}

}
