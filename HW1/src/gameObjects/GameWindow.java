package gameObjects;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private GameScreen gameScreen;

	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 250;
	
	public GameWindow() {
		super("Java T-Rex game");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		gameScreen = new GameScreen();
		add(gameScreen);
		addKeyListener(gameScreen);
		
	}
	
	public void startGame() {
		gameScreen.startGame();
	}
	
	public static void main(String args[]) {
		
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.startGame();
	}
}
