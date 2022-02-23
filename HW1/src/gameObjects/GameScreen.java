package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import characterFeatures.JumpLow;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import landFeatures.Land;
import powerups.PowerUp;
import powerups.PowerUpA;
import powerups.PowerUpB;
import powerups.PowerUpC;
import powerups.PowerUpD;
import util.GameObject;
import util.Resource;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	

	private static final long serialVersionUID = 1L;
	public static final float GRAVITY = 1.2f;
	public static final int GROUND = 200; // pixel
	public static final int DEFAULT_POINT = 2;
	public static final int MOVEMENT_SPEED = 3;
	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;
	
	private int screenEndCursor;
	
	private Thread thread;
	private MainCharacter character;
	
	private Land land;
	
	private boolean moveRight;
	
	private List<GameObject> gameObjects;
	
	private int frameCounter;
	private int randomFrame;
	
	private int totalPoint;

	private boolean isAlive;
	
	public GameScreen() {
		thread = new Thread(this);
		land = new Land();
		
		BufferedImage characterImage = Resource.getResourceImage("data/main-character1.png");
		character = new MainCharacter(new Rectangle(50, GROUND - characterImage.getHeight(), characterImage.getWidth(), characterImage.getHeight()), characterImage);
		character.setJumpBehaviour(new JumpLow());
		character.setLifeCount(3);
		
		gameObjects = new ArrayList<GameObject>();
		
		
	}
	
	public void startGame() {
		thread.start();
	}


	/**
	 * Runs all game objects run methods 
	 */
	@Override
	public void run() {
		SCREEN_WIDTH = getWidth();
		SCREEN_HEIGHT = getHeight();
		screenEndCursor = getWidth();
		frameCounter = 0;
		randomFrame = new Random().nextInt(10) + 30;
		totalPoint = 0;
		isAlive = true;
		
		land.addLandImage(Resource.getResourceImage("data/land1.png"));
		land.addLandImage(Resource.getResourceImage("data/land2.png"));
		land.addLandImage(Resource.getResourceImage("data/land3.png"));
		land.generateLandscape(this.getWidth());
		
		BufferedImage obstacleImage = Resource.getResourceImage("data/cactus1.png");
		gameObjects.add(new Obstacle(new Rectangle(screenEndCursor, GROUND - obstacleImage.getHeight(), obstacleImage.getWidth(), obstacleImage.getHeight() ), obstacleImage));
		
		
		while(true) {
			
			if(isAlive) {
				if(moveRight) {
					frameCounter++;
					land.update();
					updateScreenCursors();
					
					for(GameObject go : gameObjects){
						go.update();
					}
					
					if(gameObjects.size() >0 && gameObjects.get(0).getCollisionBox().x + gameObjects.get(0).getCollisionBox().getWidth() < 0 ) {
						gameObjects.remove(0);
					}
					
					if(frameCounter == randomFrame) {
						gameObjects.add(getRandomGameObject());
						frameCounter = 0;
						randomFrame = new Random().nextInt(10) + 30;
					}
				}
					
				isColliding();
				character.update();
				
				if(getsPoint()) {
					if(character.getPowerUp() == null)
						totalPoint += 1;
					else
						totalPoint += 1*character.getPowerUp().getMultiplier();
					
					System.out.println("point: " + totalPoint);
				}
			}
			
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && character.isOnGround()) {
			character.performJump();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			moveRight = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			moveRight = false;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(isAlive) {
			
			g.setColor(Color.black);
			g.drawLine(0, GROUND, getWidth(), GROUND);
			land.draw(g);
			
			for(GameObject go : gameObjects){
				go.draw(g);
			}
			
			character.draw(g);
			if(character.getPowerUp() == null)
				g.drawString("x " + String.valueOf(1), getWidth() - 100, 20);
			else {
				g.drawString("x " + String.valueOf( 1 * character.getPowerUp().getMultiplier()), getWidth() - 100, 20);
			}
			
			g.drawString("Life: " + String.valueOf(character.getLifeCount()), getWidth() - 200, 20);
			
			g.drawString("Points: " + String.valueOf(totalPoint), getWidth() - 300, 20);
		}
		else {
			g.setColor(Color.black);
			g.drawString("GAME OVER", 100, 100);
		}
		
		
	}
	
	
	/**
	 * Check character is colliding and take action according to it
	 */
	private void isColliding() {
		for(int i=0; i<gameObjects.size(); i++) {
			GameObject go = gameObjects.get(i);
			if(go.getCollisionBox().intersects(character.getCollisionBox())) {
				if(go instanceof Obstacle) {
					character.decrementLifeCount();
					if(character.getLifeCount() <= 0) {
						isAlive = false;
						System.out.println("oyun bitti");
					}
				}
				else {
					
					if(go instanceof PowerUpD) {
						character.setJumpBehaviour(((PowerUpD)go).changeJumpMod(character.getJumpBehavior()));
						System.out.println(((PowerUpD)go).getDescription() + " Acquired" + " jump mode changed");
					}
					else if(character.getPowerUp() == null) {
						character.setPowerUp(((PowerUp)go));
						System.out.println(((PowerUp)go).getDescription() + " Acquired");
					}
					else if(go instanceof PowerUpA) {
						((PowerUpA)go).setPowerUp(character.getPowerUp());
						character.setPowerUp(((PowerUpA)go));
						System.out.println(((PowerUp)go).getDescription() + " Acquired");
					}
					else if(go instanceof PowerUpB) {
						((PowerUpB)go).setPowerUp(character.getPowerUp());
						character.setPowerUp(((PowerUpB)go));
						System.out.println(((PowerUp)go).getDescription() + " Acquired");
					}
					else if(go instanceof PowerUpC) {
						((PowerUpC)go).setPowerUp(character.getPowerUp());
						character.setPowerUp(((PowerUpC)go));
						System.out.println(((PowerUp)go).getDescription() + " Acquired");
					}
				}
				gameObjects.remove(i);
			}
		}
	}
	
	
	/**
	 * Increment screenEndCursor with MOVEMENT_SPEED
	 */
	private void updateScreenCursors() {
		screenEndCursor += MOVEMENT_SPEED;
	}
	
	
	/**
	 * Returns a random game object to be added game
	 * @return a random game object to be added game
	 */
	private GameObject getRandomGameObject() {
		GameObject newGO = null;
		
		if(new Random().nextBoolean()) {
			BufferedImage tmpImage = Resource.getResourceImage("data/cactus1.png");
			newGO = new Obstacle(new Rectangle(screenEndCursor, GROUND - tmpImage.getHeight(), tmpImage.getWidth(), tmpImage.getHeight() ), tmpImage);
		}
		else {
			switch(new Random().nextInt(4)) {
				case 0:
					newGO = new PowerUpA(null);
					newGO.setCollisionBox(new Rectangle(screenEndCursor,GROUND - 30,20,20));
					break;
				case 1:
					newGO = new PowerUpB(null);
					newGO.setCollisionBox(new Rectangle(screenEndCursor,GROUND - 30,20,20));
					break;
				case 2:
					newGO = new PowerUpC(null);
					newGO.setCollisionBox(new Rectangle(screenEndCursor,GROUND - 30,20,20));
					break;
				case 3:
					newGO = new PowerUpD();
					newGO.setCollisionBox(new Rectangle(screenEndCursor,GROUND - 30,20,20));
					break;
			}
		}
		
		return newGO;
	}

	
	/**
	 * Checks character successfully jump over obstacle
	 * @return true if character successfully jump over obstacle, otherwise false
	 */
	private boolean getsPoint() {
		for(GameObject go: gameObjects) {
			if(go instanceof Obstacle) {
				if(((Obstacle)go).getPointBox() != null && ((Obstacle)go).getPointBox().intersects(character.getCollisionBox())) {
					((Obstacle)go).setPointBox(null);
					return true;
				}
					
			}
		}
		
		return false;
	}
}