package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import acm.program.GraphicsProgram;
import starter.GraphicsPane;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Timer;
import acm.graphics.*;

public class ShopGraphics extends GraphicsPane {
	private static final Card[] Card = null;
	private MainMenu program;
	private GImage shopbackground;
	private GImage sell;
	private GImage buy;
	private GImage back;
	private GObject target;
	private int lastX = 0;
	private int lastY = 0;
	
	private boolean transition = false;
	private GRect hover = new GRect(0, 0, MainMenu.RESOLUTION_X / 5, MainMenu.RESOLUTION_Y / 5);
	private GRect blackscrn = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y );//Black screen for fade out
	
	public ShopGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	
	public void initializeObjects() {
		shopbackground = new GImage("media/images/shop background.jpg", 0, 0);
		shopbackground.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);	
		sell= new GImage("media/images/sell-hi.png", 188, 388);
		sell.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);	
		buy= new GImage("media/images/buy-20clipart-buy-md.png", 666, 388);
		buy.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);
		back= new GImage("media/images/back_button.png", 1377, 388);
		back.setSize(MainMenu.RESOLUTION_X/5, MainMenu.RESOLUTION_Y/5);
        hover.setSize(MainMenu.RESOLUTION_X / 5, MainMenu.RESOLUTION_Y / 5);
		
        hover.setColor(new Color( 0,0,0,8));
		hover.setFilled(true);
		hover.setFillColor(new Color(8));
		hover.setVisible(false);
		blackscrn.setFillColor(new Color(0, 0, 0, 5));
		blackscrn.setFilled(true);
	}
	
	
	public void mouseMoved(MouseEvent e) {	
		if (program.getElementAt(e.getX(), e.getY()) == sell || program.getElementAt(e.getX(), e.getY()) == buy || program.getElementAt(e.getX(), e.getY()) == back ) {
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
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(target == null) {
			
		} else {
			program.getAudioPlayer().playSound("media/sounds", "select.mp3");
			
		}
		

		GObject currElem = program.getElementAt(e.getX(), e.getY());
		if (currElem instanceof GImage) {
			if(target == sell) {
				System.out.println("shop background.jpg");	
				
			} else if(target == buy){
				System.out.println("sell-hi.png");
					
			} else if (currElem == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}
		
	}
	

	
	
	@Override
	public void showContents() {
		program.add(shopbackground);
		program.add(sell);
		program.add(buy);
		program.add(back);
		program.add(MainMenuGraphics.menuButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(shopbackground);
		program.remove(sell);
		program.remove(buy);
		program.remove(back);
		program.remove(MainMenuGraphics.menuButton);
	}
	
	public void scroll() {
		Random random = new Random();
		
	        for(int i = 0; i < Card.length; i++){
	           int c = random.nextInt(Card.length);
				Card temp = Card[i];
	            Card[i] = Card[c];
	            Card[c] = temp;
	        }
}
	public Card[] getCard()
    {
        return Card;
        
   }
	
}







