package project;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Timer;



import acm.graphics.*;
import acm.program.GraphicsProgram;
import starter.AudioPlayer;
import starter.GraphicsPane;

public class MainMenuGraphics extends GraphicsPane implements ActionListener {
	
	private MainMenu program;

	public static GImage menuButton = new GImage("media/images/MenuButton.png", 1700, 810);
	
	private static GImage title = new GImage("media/images/Title.jpg");
	private static GImage play = new GImage("media/images/PlayButton.png");
	private static GImage shop = new GImage("media/images/Shop.png");
	private static GImage charSelect = new GImage("media/images/CharacterSelect.png");
	private static GImage background = new GImage("media/images/Background.png", 0, 0);//Yeah I know the background is low res, it's just a placeholder 
	private static GImage quit = new GImage("media/images/Quit.png", 0, 0);
	private AudioPlayer snd;
	private Timer someTimeVar = new Timer(50, this);
	private static GObject target;
	private GRect hover = new GRect(0, 0, MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
	private GRect blackscrn = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y );//Black screen for fade out
	private int scrAlpha = 5;
	private int lastX = 0;
	private int lastY = 0;
	private boolean transition = false;
	
	
	public MainMenuGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	public void initializeObjects() {
		snd = AudioPlayer.getInstance();
		someTimeVar.start();
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		//Mess around with locations later to make them equal distance from each other
		play.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		play.setLocation(MainMenu.RESOLUTION_X / 2 - play.getWidth()/2, MainMenu.RESOLUTION_Y / 3);
		shop.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		shop.setLocation(MainMenu.RESOLUTION_X / 3 - shop.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		charSelect.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		charSelect.setLocation(MainMenu.RESOLUTION_X * 2 / 3 - charSelect.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		title.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y / 6);
		title.setLocation(MainMenu.RESOLUTION_X / 2 - title.getWidth()/2, MainMenu.RESOLUTION_Y / 8);
		hover.setSize(MainMenu.RESOLUTION_X / 6 + 16, MainMenu.RESOLUTION_Y / 6 + 16);
		hover.setColor(new Color(0, 0, 0, 255));
		hover.setFilled(true);
		hover.setFillColor(new Color(255));
		hover.setVisible(false);
		blackscrn.setFillColor(new Color(0, 0, 0, 5));
		blackscrn.setFilled(true);
		quit.setSize(128, 128);
		quit.setLocation(MainMenu.RESOLUTION_X - quit.getWidth(), 0);
	}

	//Trying to get custom cursor to work, not working for some reason. Check back if you have time, if not just ignore Ask David maybe?
	public void setCustomCursor() {	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("media/images/Cursor.png");
		Point hotspot = new Point(0, 0);
		Cursor cursor = toolkit.createCustomCursor(img, hotspot, "mainCursor");
		program.setCursor(cursor);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//Mouse event for all button options
		if((program.getElementAt(e.getX(), e.getY()) == play || program.getElementAt(e.getX(), e.getY()) == shop || program.getElementAt(e.getX(), e.getY()) == charSelect) ){
			program.getAudioPlayer().playSound("media/sounds/", "select.mp3");
			transition = true;
			program.add(blackscrn);
		} else if(program.getElementAt(e.getX(),e.getY()) == quit){
			System.exit(0);
				}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(transition) {
			if (hover.isVisible()) {
				hover.setVisible(false);
			} else {
				hover.setVisible(true);
			}
			
			if (scrAlpha < 255) {
				scrAlpha+= 10;
				blackscrn.setFillColor(new Color(0, 0, 0, scrAlpha));
			} else {
				program.remove(blackscrn);
				
				if (target == play) {
					program.openGame();
				} else if(target == shop){
					program.openShop();
				} else if(target == charSelect) {
					program.openCharacterSelect();
				}
				scrAlpha = 5; 
				target = null;
				transition = false;
				someTimeVar.stop();
			}
        }
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		//Mouse Hovering
		//TODO:Need to optimize
		if(!transition) {
		if((program.getElementAt(e.getX(), e.getY()) == play || program.getElementAt(e.getX(), e.getY()) == shop || program.getElementAt(e.getX(), e.getY()) == charSelect) ){
			//hover = getElementAt(e.getX(), e.getY());
			hover.setLocation(program.getElementAt(e.getX(), e.getY()).getX() - 8,  program.getElementAt(e.getX(), e.getY()).getY() - 8);
			hover.setVisible(true);
			target = program.getElementAt(e.getX(), e.getY());
			if (program.getElementAt(e.getX(), e.getY()) != program.getElementAt(lastX, lastY)) {
				program.getAudioPlayer().playSound("media/sounds/", "cardHover.mp3");
			}
		} else {
			hover.setVisible(false);
			target = null;
		}
		
		lastX = e.getX();
		lastY = e.getY();
	}
	}
	
	@Override
	public void showContents() {
		setCustomCursor();
		someTimeVar.start(); 
		program.add(title);
		program.add(background);
		program.add(hover);
		program.add(title);
		program.add(play);
		program.add(shop);
		program.add(charSelect);
		program.add(quit);
		
	}
	
	@Override
	public void hideContents() {
		
		program.remove(blackscrn);
		program.remove(title);
		program.remove(background);
		program.remove(hover);
		program.remove(title);
		program.remove(play);
		program.remove(shop);
		program.remove(charSelect);
		program.remove(quit);
		someTimeVar.stop();
		
	}
	
}
