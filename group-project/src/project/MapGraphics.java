package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import project.cards.LargeHealthPotion;
import project.cards.LargeManaPotion;
import project.cards.LifeSteal;
import project.cards.ManaRevive;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.SmallManaPotion;
import project.cards.SoulSteal;
import project.cards.Split;
import project.cards.Stab;
import project.cards.Stick;
import project.cards.Suicide;
import starter.GraphicsPane;

public class MapGraphics extends GraphicsPane {

	private MainMenu program;
	
	private GImage background;
	private Level levelOne;
	private Level levelTwo;
	private Level levelThree;
	private Level levelFour;
	private Level levelFive;
	private Level levelSix;
	private Level levelSeven;
	private Level levelEight;
	private Level levelNine;
	private Level levelTen;
	private Level levelEleven;
	private Level levelTwelve;
	private Level levelThirteen;
	private Level levelFourteen;
	private Level levelFifteen;
	private Level levelSixteen;
	private Level levelSeventeen;
	private Level levelEighteen;
	private Level levelNineteen;
	private Level levelTwenty;
	
	private ArrayList<Level> levelList1;
	private ArrayList<Level> levelList2;
	private GImage levelHovered;
	
	public MapGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	private void initializeObjects() {
		background = new GImage("media/images/Background.png", 0, 0);
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
		levelList1 = new ArrayList<>();
		levelList2 = new ArrayList<>();
		Enemy levelOneEnemy = new Enemy("Fish", new GImage("media/images/monsters/LevelOne.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion())));
		Enemy levelTwoEnemy = new Enemy("Chicken", new GImage("media/images/monsters/LevelTwo.png"), 6, 6, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new Slash())));
		Enemy levelThreeEnemy = new Enemy("Sheep", new GImage("media/images/monsters/LevelThree.png"), 7, 7, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash())));
		Enemy levelFourEnemy = new Enemy("Squid", new GImage("media/images/monsters/LevelFour.png"), 8, 8, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split())));
		Enemy levelFiveEnemy = new Enemy("Rabbit", new GImage("media/images/monsters/LevelFive.png"), 9, 9, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split())));
		Enemy levelSixEnemy = new Enemy("Pig", new GImage("media/images/monsters/LevelSix.png"), 10, 10, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion())));
		Enemy levelSevenEnemy = new Enemy("Cow", new GImage("media/images/monsters/LevelSeven.png"), 11, 11, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion())));
		Enemy levelEightEnemy = new Enemy("Bat", new GImage("media/images/monsters/LevelEight.png"), 12, 12, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion())));
		Enemy levelNineEnemy = new Enemy("Spider", new GImage("media/images/monsters/LevelNine.png"), 13, 13, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion())));
		Enemy levelTenEnemy = new Enemy("Dolphin", new GImage("media/images/monsters/LevelTen.png"), 14, 14, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal())));
		Enemy levelElevenEnemy = new Enemy("Panda", new GImage("media/images/monsters/LevelEleven.png"), 15, 15, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal())));
		Enemy levelTwelveEnemy = new Enemy("Bear", new GImage("media/images/monsters/LevelTwelve.png"), 16, 16, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab())));
		Enemy levelThirteenEnemy = new Enemy("Wolf", new GImage("media/images/monsters/LevelThirteen.png"), 17, 17, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab())));
		Enemy levelFourteenEnemy = new Enemy("Silverfish", new GImage("media/images/monsters/LevelFourteen.png"), 18, 18, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive())));
		Enemy levelFifteenEnemy = new Enemy("Zombie", new GImage("media/images/monsters/LevelFifteen.png"), 19, 19, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive())));
		Enemy levelSixteenEnemy = new Enemy("Skeleton", new GImage("media/images/monsters/LevelSixteen.png"), 20, 20, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive(), new Revive())));
		Enemy levelSeventeenEnemy = new Enemy("Witch", new GImage("media/images/monsters/LevelSeventeen.png"), 21, 21, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive(), new Revive())));
		Enemy levelEighteenEnemy = new Enemy("Ogre", new GImage("media/images/monsters/LevelEighteen.png"), 22, 22, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive(), new Revive(), new SoulSteal())));
		Enemy levelNineteenEnemy = new Enemy("Kraken", new GImage("media/images/monsters/LevelNineteen.png"), 23, 23, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive(), new Revive(), new SoulSteal())));
		Enemy levelTwentyEnemy = new Enemy("Dragon", new GImage("media/images/monsters/LevelTwenty.png"), 24, 24, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick(), new SmallManaPotion(), new SmallHealthPotion(), new Slash(), new Split(), new LargeManaPotion(), new LargeHealthPotion(), new LifeSteal(), new Stab(), new ManaRevive(), new Revive(), new SoulSteal(), new Suicide())));


		levelOne = new Level(new GImage("media/images/level1.png", 1 * 300, 1 * 200), 1, levelOneEnemy, false, new Reward(program.getPlayer(), 10, null));
		levelTwo = new Level(new GImage("media/images/level2.png", 2 * 300, 1 * 200), 2, levelTwoEnemy, false, new Reward(program.getPlayer(), 20, new Slash()));
		levelThree = new Level(new GImage("media/images/level3.png", 3 * 300, 1 * 200), 3, levelThreeEnemy, false, new Reward(program.getPlayer(), 30, null));
		levelFour = new Level(new GImage("media/images/level4.png", 4 * 300, 1 * 200), 4, levelFourEnemy, false, new Reward(program.getPlayer(), 40, new Split()));
		levelFive = new Level(new GImage("media/images/level5.png", 5 * 300, 1 * 200), 5, levelFiveEnemy, false, new Reward(program.getPlayer(), 50, null));
		levelSix = new Level(new GImage("media/images/level6.png", 1 * 300, 3 * 200), 6, levelSixEnemy, false, new Reward(program.getPlayer(), 60, new LargeManaPotion()));
		levelSeven = new Level(new GImage("media/images/level7.png", 2 * 300, 3 * 200), 7, levelSevenEnemy, false, new Reward(program.getPlayer(), 70, null));
		levelEight = new Level(new GImage("media/images/level8.png", 3 * 300, 3 * 200), 8, levelEightEnemy, false, new Reward(program.getPlayer(), 80, new LargeHealthPotion()));
		levelNine = new Level(new GImage("media/images/level9.png", 4 * 300, 3 * 200), 9, levelNineEnemy, false, new Reward(program.getPlayer(), 90, null));
		levelTen = new Level(new GImage("media/images/level10.png", 5 * 300, 3 * 200), 10, levelTenEnemy, false, new Reward(program.getPlayer(), 100, new LifeSteal()));
		levelEleven = new Level(new GImage("media/images/level11.png", 1 * 300, 2 * 200), 11, levelElevenEnemy, false, new Reward(program.getPlayer(), 110, null));
		levelTwelve = new Level(new GImage("media/images/level12.png", 2 * 300, 2 * 200), 12, levelTwelveEnemy, false, new Reward(program.getPlayer(), 120, new Stab()));
		levelThirteen = new Level(new GImage("media/images/level13.png", 3 * 300, 2 * 200), 13, levelThirteenEnemy, false, new Reward(program.getPlayer(), 130, null));
		levelFourteen = new Level(new GImage("media/images/level14.png", 4 * 300, 2 * 200), 14, levelFourteenEnemy, false, new Reward(program.getPlayer(), 140, new ManaRevive()));
		levelFifteen = new Level(new GImage("media/images/level15.png", 5 * 300, 2 * 200), 15, levelFifteenEnemy, false, new Reward(program.getPlayer(), 150, null));
		levelSixteen = new Level(new GImage("media/images/level16.png", 1 * 300, 4 * 200), 16, levelSixteenEnemy, false, new Reward(program.getPlayer(), 160, new Revive()));
		levelSeventeen = new Level(new GImage("media/images/level17.png", 2 * 300, 4 * 200), 17, levelSeventeenEnemy, false, new Reward(program.getPlayer(), 170, null));
		levelEighteen = new Level(new GImage("media/images/level18.png", 3 * 300, 4 * 200), 18, levelEighteenEnemy, false, new Reward(program.getPlayer(), 180, new SoulSteal()));
		levelNineteen = new Level(new GImage("media/images/level19.png", 4 * 300, 4 * 200), 19, levelNineteenEnemy, false, new Reward(program.getPlayer(), 190, null));
		levelTwenty = new Level(new GImage("media/images/level20.png", 5 * 300, 4 * 200), 20, levelTwentyEnemy, false, new Reward(program.getPlayer(), 200, new Suicide()));

		levelList1.add(levelOne);
		levelList1.add(levelTwo);
		levelList1.add(levelThree);
		levelList1.add(levelFour);
		levelList1.add(levelFive);
		levelList1.add(levelSix);
		levelList1.add(levelSeven);
		levelList1.add(levelEight);
		levelList1.add(levelNine);
		levelList1.add(levelTen);
		levelList2.add(levelEleven);
		levelList2.add(levelTwelve);
		levelList2.add(levelThirteen);
		levelList2.add(levelFourteen);
		levelList2.add(levelFifteen);
		levelList2.add(levelSixteen);
		levelList2.add(levelSeventeen);
		levelList2.add(levelEighteen);
		levelList2.add(levelNineteen);
		levelList2.add(levelTwenty);
		
		loadLevels();
	}
	
	public void loadLevels() {
		int currLevel = Integer.parseInt(ConfigManager.getPath("level"));
		
		for (Level level : levelList1) {
			level.getLevelImage().setSize(150, 150);
			level.getLevelImage().setVisible(false);
		}
		for (Level level : levelList2) {
			level.getLevelImage().setSize(150, 150);
			level.getLevelImage().setVisible(false);
		}
		
		if (currLevel > 10) {
			for (Level level : levelList2) {
				if (level.getLevelNumber() >= currLevel) {
					level.getLevelImage().setVisible(true);
				}
			}
		} else {
			for (Level level : levelList1) {
				if (level.getLevelNumber() >= currLevel) {
					level.getLevelImage().setVisible(true);
				}
			}
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		if (currElem instanceof GImage) {
			for (Level level : levelList1) {
				if (level.getLevelImage() == currElem && Integer.parseInt(ConfigManager.getPath("level")) == level.getLevelNumber()) {
					if (!checkIfDeckEmpty())
						program.openBoard(level);
				}
			}
			for (Level level : levelList2) {
				if (level.getLevelImage() == currElem && Integer.parseInt(ConfigManager.getPath("level")) == level.getLevelNumber()) {
					if (!checkIfDeckEmpty())
						program.openBoard(level);
				}
			}
			if (currElem == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}
	}
	
	//todo fix
	private boolean checkIfDeckEmpty() {
		if (program.getPlayer().getDeck().isEmpty()) {
			new Thread() {
				public void run() {
					
					GLabel emptyLabel = new GLabel("DECK IS EMPTY");
					emptyLabel.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					
					emptyLabel.setLocation(1920/2 - 75, 1080/2 - 25);
					
					program.add(emptyLabel);
					
					for (int x = 0; x < 30; x++) {
						emptyLabel.move(0, 10);
						program.pause(100);
					}
					
					program.remove(emptyLabel);
				}
			}.start();
			return true;
		}
		return false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		
		if (currElem instanceof GImage) {
			for (Level level : levelList1) {
				if (level.getLevelImage() == currElem) {
					levelHovered = level.getLevelImage();
					levelHovered.setSize(140, 140);
					return;
				}
			}
			for (Level level : levelList2) {
				if (level.getLevelImage() == currElem) {
					levelHovered = level.getLevelImage();
					levelHovered.setSize(140, 140);
					return;
				}
			}
		}
		
		if (levelHovered != null) {
			levelHovered.setSize(150, 150);
			levelHovered = null;
		}
		
	}
	 
	@Override
	public void showContents() {
		program.add(background);

		for (Level level : levelList1) {
			program.add(level.getLevelImage());
		}
		for (Level level : levelList2) {
			program.add(level.getLevelImage());
		}

		program.add(MainMenuGraphics.menuButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);

		for (Level level : levelList1) {
			program.remove(level.getLevelImage());
		}
		for (Level level : levelList2) {
			program.remove(level.getLevelImage());
		}
		
		program.remove(MainMenuGraphics.menuButton);
	}
}
