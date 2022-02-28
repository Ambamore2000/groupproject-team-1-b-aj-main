package project;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import starter.GraphicsPane;

public class CharacterSelectGraphics extends GraphicsPane {

	private MainMenu program;
	
	private GRect outline = new GRect(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
	private GImage maleKnight;
	private GImage femaleKnight;
	private GImage maleMagician;
	private GImage femaleMagician;
	
	public CharacterSelectGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	public void initializeObjects() {
		maleKnight = new GImage("media/images/MaleKnight.png", 0 * (MainMenu.RESOLUTION_X / 4), 0);
		maleKnight.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		femaleKnight = new GImage("media/images/FemaleKnight.png", 1 * (MainMenu.RESOLUTION_X / 4), 0);
		femaleKnight.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		maleMagician = new GImage("media/images/MaleMagician.png", 2 * (MainMenu.RESOLUTION_X / 4), 0);
		maleMagician.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		femaleMagician = new GImage("media/images/FemaleMagician.png", 3 * (MainMenu.RESOLUTION_X / 4), 0);
		femaleMagician.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		outline.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		outline.setColor(new Color(0, 0, 0, 255));
		outline.setFilled(true);
		outline.setFillColor(new Color(0, 0, 0, 255));
		outline.setVisible(true);
		
		setOutlineLocation();
	}
	
	private void setOutlineLocation() {
		String characterString = ConfigManager.getPath("character");
		
		GImage characterImage = null;
		
		if (characterString.equalsIgnoreCase("maleknight")) {
			characterImage = maleKnight;
		} else if (characterString.equalsIgnoreCase("femaleknight")) {
			characterImage = femaleKnight;
		} else if (characterString.equalsIgnoreCase("malemagician")) {
			characterImage = maleMagician;
		} else if (characterString.equalsIgnoreCase("femalemagician")) {
			characterImage = femaleMagician;
		}
		
		setPlayerSprite(characterImage);
		
		outline.setLocation(characterImage.getX(), characterImage.getY());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (program.getElementAt(e.getX(), e.getY()) instanceof GImage) {
			GImage clickedImage = (GImage) program.getElementAt(e.getX(), e.getY());
			if (clickedImage == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}

		if(program.getElementAt(e.getX(), e.getY()) == maleKnight || 
				program.getElementAt(e.getX(), e.getY()) == femaleKnight || 
				program.getElementAt(e.getX(), e.getY()) == maleMagician || 
				program.getElementAt(e.getX(), e.getY()) == femaleMagician) {
			outline.setLocation(program.getElementAt(e.getX(), e.getY()).getX(), program.getElementAt(e.getX(), e.getY()).getY());
			//System.out.print("no");
			outline.setVisible(true);
			String characterSelect = null;
			
			GImage characterImage = null;

			if(program.getElementAt(e.getX(), e.getY()) == maleKnight) {
				characterSelect = "maleknight";
				characterImage = maleKnight;
			}
			else if(program.getElementAt(e.getX(), e.getY()) == femaleKnight) {
				characterSelect = "femaleknight";
				characterImage = femaleKnight;
			}
			else if(program.getElementAt(e.getX(), e.getY()) == maleMagician) {
				characterSelect = "malemagician";
				characterImage = maleMagician;
			}
			else if(program.getElementAt(e.getX(), e.getY()) == femaleMagician) {
				characterSelect = "femalemagician";
				characterImage = femaleMagician;
			}
			ConfigManager.setPath("character", characterSelect);
			setPlayerSprite(characterImage);
		}
	}
	
	public void setPlayerSprite(GImage playerSprite) {
		program.getPlayer().setSprite(playerSprite);
	}

	@Override
	public void showContents() {
		program.add(outline);
		program.add(maleKnight);
		program.add(femaleKnight);
		program.add(maleMagician);
		program.add(femaleMagician);
		program.add(MainMenuGraphics.menuButton);
		setOutlineLocation();
	}

	@Override
	public void hideContents() {
		program.remove(outline);
		program.remove(maleKnight);
		program.remove(femaleKnight);
		program.remove(maleMagician);
		program.remove(femaleMagician);
		program.remove(MainMenuGraphics.menuButton);
	}
	
}
