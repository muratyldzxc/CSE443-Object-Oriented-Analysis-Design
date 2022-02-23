package landFeatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import util.Drawable;
import util.Updatable;
import static gameObjects.GameScreen.MOVEMENT_SPEED;

public class Land implements Drawable, Updatable{
	
	private List<BufferedImage> landImages;
	private List<ImageLand> landscapes;
	
	public Land() {
		
		landImages = new ArrayList<BufferedImage>();
		landscapes = new ArrayList<ImageLand>();
	}
	
	/**
	 * adds an image to land images
	 * @param i image will be added
	 */
	public void addLandImage(BufferedImage i) {
		landImages.add(i);
	}
	
	/**
	 * Creates a Landscape from given land images
	 * @param screenWidth will be used to fill whole screen
	 */
	public void generateLandscape(int screenWidth) {
		int posX = 0;
		
		while(posX < screenWidth*2) {
			
			ImageLand newImageLand = new ImageLand();
			newImageLand.image = getRandomLandImage();
			newImageLand.posX = posX;
			landscapes.add(newImageLand);
			
			posX += newImageLand.image.getWidth();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		
		Iterator<ImageLand> lands = landscapes.iterator();
		
		for(int i=0; i<landscapes.size(); i++) {
			ImageLand tmpLand = lands.next();
			g.drawImage(tmpLand.image, tmpLand.posX, 200 - tmpLand.image.getHeight()/2, null);
		}
	}
	
	@Override
	public void update() {
		for(ImageLand imageLand: landscapes) {
			imageLand.posX -= MOVEMENT_SPEED;
		}
		
		ImageLand firstLand = landscapes.get(0);
		
		if(firstLand.posX + firstLand.image.getWidth() <= 0) {
			
			ImageLand lastLand = landscapes.get(landscapes.size()-1);
			
			ImageLand newImageLand = new ImageLand();
			newImageLand.image = getRandomLandImage();
			newImageLand.posX = lastLand.posX + lastLand.image.getWidth();;
			
			landscapes.add(newImageLand);
			landscapes.remove(0);
		}
	}
	
	private class ImageLand{
		private int posX;
		private BufferedImage image;
	}
	
	
	/**
	 * Returns a random image from land images
	 * @return a random image from land images
	 */
	private BufferedImage getRandomLandImage() {
		int i = (new Random()).nextInt(landImages.size());
		
		return  landImages.get(i);
	}
}
