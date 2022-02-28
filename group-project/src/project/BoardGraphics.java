package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import project.cards.LargeHealthPotion;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.Stab;
import project.cards.Stick;
import starter.GraphicsPane;

//ANDREW

public class BoardGraphics extends GraphicsPane {

	private MainMenu program;
	
	private Font statsFont = new Font("TimesRoman", Font.PLAIN, 50);
	
	private GImage background = new GImage("media/images/DungeonBackground.jpg");
	
	private static GRect enemyHealthBar;
	//private static GRect enemyArmorBar;
	
	private static GLabel playerHealthText;
	private static GImage playerHealthBar = new GImage("media/images/PlayerHealth.png", 0, 0);
	private static GRect playerHealthDamageBar;
	
	private static GLabel playerManaText;
	private static GImage playerManaBar = new GImage("media/images/PlayerMana.png", 0, 82);
	private static GRect playerManaUseBar;
	
	private static GImage endTurnButton = new GImage("media/images/EndTurnButton.png", 1700, 800);
	
	private static GLabel turnText;
	private int turnNumber;
	
	private Level level;
	
	//private GLabel playerArmorText; //TODO
	//private GImage playerArmorBar; //TODO
	
	//TODO Player end button.

	private static int PLAYER_BAR_WIDTH;
	private static int ENEMY_BAR_WIDTH;
	
	private Player player;
	private Enemy enemy;
	
	private boolean isPlayerTurn = true;
	
	public BoardGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	public void initializeObjects() {
		enemyHealthBar = new GRect(843, 640, 193, 15);
		enemyHealthBar.setFillColor(Color.RED);
		enemyHealthBar.setFilled(true);
		
		//enemyArmorBar = new GRect(843, 680, 193, 5);
		//enemyArmorBar.setFillColor(Color.GRAY);
		//enemyArmorBar.setFilled(true);
		
		playerHealthBar.setSize(366, 82);
		playerHealthDamageBar = new GRect(80, 12, 273, 57);
		playerHealthDamageBar.setFilled(true);
		playerHealthDamageBar.setFillColor(Color.GREEN);
		playerHealthDamageBar.setColor(Color.GREEN);
		playerHealthText = new GLabel("10/10");
		playerHealthText.setLocation(176, 57);
		playerHealthText.setFont(statsFont);
		
		playerManaBar.setSize(366, 82);
		playerManaUseBar = new GRect(80, 94, 273, 57);
		playerManaUseBar.setFilled(true);
		playerManaUseBar.setFillColor(Color.BLUE);
		playerManaUseBar.setColor(Color.BLUE);
		playerManaText = new GLabel("10/10");
		playerManaText.setLocation(176, 140);
		playerManaText.setFont(statsFont);
		
		turnNumber = 1;
		
		turnText = new GLabel("Turn: 1");
		turnText.setFont(statsFont);
		turnText.setLocation(1700, 50);
		turnText.setColor(Color.WHITE);
		/*
		playerArmorBar = new GImage("media/images/PlayerArmor.png", 0, 164);
		playerArmorBar.setSize(148, 82);
		playerArmorText = new GLabel("10"); //TODO getMana
		playerArmorText.setLocation(82, 220);
		playerArmorText.setFont(statsFont);
		add(playerArmorBar);
		add(playerArmorText);
		*/
		
		PLAYER_BAR_WIDTH = (int) playerHealthDamageBar.getWidth();
		ENEMY_BAR_WIDTH = (int) enemyHealthBar.getWidth();
		
	}
	
	public void checkIfDead() {
		if (player.isDead() || enemy.isDead()) {
			new Thread() {
				public void run() {

					GRect mainRect = new GRect(0, 0);
					mainRect.setBounds(500, 150, 920, 780);
					mainRect.setFillColor(Color.GRAY);
					mainRect.setFilled(true);
					program.add(mainRect);
					
					if (player.isDead()) {
						GRect gameOverRect = new GRect(0, 0);
						gameOverRect.setBounds(600, 250, 720, 150);
						gameOverRect.setFillColor(Color.RED);
						gameOverRect.setFilled(true);
						GLabel gameOverLabel = new GLabel("GAME OVER");
						gameOverLabel.setLocation(850, 350);
						gameOverLabel.setFont(statsFont);
						
						program.add(gameOverRect);
						program.add(gameOverLabel);
						
						program.pause(4000);
						
						program.remove(gameOverRect);
						program.remove(gameOverLabel);
					} else if (enemy.isDead()) {
						if (level.getLevelNumber() >= Integer.parseInt(ConfigManager.getPath("level"))) {
							ConfigManager.setPath("level", String.valueOf((level.getLevelNumber() + 1)));
						}
						program.getMapGraphics().loadLevels();
						
						GRect goldRewardRect = new GRect(0, 0);
						goldRewardRect.setBounds(600, 250, 720, 150);
						goldRewardRect.setFillColor(Color.YELLOW);
						goldRewardRect.setFilled(true);
						GLabel goldRewardLabel = new GLabel("+" + level.getReward().getGold() + " Gold ");
						goldRewardLabel.setLocation(850, 350);
						goldRewardLabel.setFont(statsFont);
						program.add(goldRewardRect);
						program.add(goldRewardLabel);
						
						GRect cardRewardRect = null;
						GLabel cardRewardLabel = null;
						GImage cardRewardImage = null;
						
						GLabel alreadyOwnedLabel = null;

						player.resetDeck();
						
						if (level.getReward().getCard() != null) {
							cardRewardRect = new GRect(0, 0);
							cardRewardLabel = new GLabel("+" + level.getReward().getCard().getName() + " Card");
							cardRewardImage = level.getReward().getCard().getPicture();
							
							cardRewardRect.setBounds(600, 450, 720, 450);
							cardRewardRect.setFillColor(Color.GREEN);
							cardRewardRect.setFilled(true);
							cardRewardLabel.setLocation(650, 550);
							cardRewardLabel.setFont(statsFont);
							cardRewardImage.setLocation(850, 575);
							program.add(cardRewardRect);
							program.add(cardRewardLabel);
							program.add(cardRewardImage);
							
							if (player.hasCard(level.getReward().getCard())) {
								alreadyOwnedLabel = new GLabel("ALREADY OWNED");
								alreadyOwnedLabel.setColor(Color.RED);
								alreadyOwnedLabel.setLocation(650, 500);
								alreadyOwnedLabel.setFont(statsFont);
								program.add(alreadyOwnedLabel);
							}
						}
						
						level.getReward().giveReward();
						
						program.pause(4000);
						
						program.remove(goldRewardRect);
						program.remove(goldRewardLabel);
						if (level.getReward().getCard() != null) {
							program.remove(cardRewardRect);
							program.remove(cardRewardLabel);
							program.remove(cardRewardImage);
						}
						if (alreadyOwnedLabel != null) {
							program.remove(alreadyOwnedLabel);
						}
					}

					program.remove(mainRect);

					program.getSettings().closeSettings();
					
					program.openGame();
				}
			}.start();
			
			isPlayerTurn = true;
			
			for (Card cards : player.getHand()) {
				program.remove(cards.getPicture());
			}
			
		}
	}
	
	public void increaseTurn() {
		if (isPlayerTurn) {
			turnNumber = turnNumber + 1;
			turnText.setLabel("Turn: " + turnNumber);
			turnText.setColor(Color.WHITE);
		} else {
			turnText.setColor(Color.RED);
		}
	}
	
	public void setLevel(Level level) {
		this.level = level;
		this.enemy = level.getEnemy();
		enemy.getSprite().setBounds(500, 200, 900, 450);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void loadCards() {
		player.drawCard();
		enemy.drawCard();
		
		reloadHand();
	}
	
	private void reloadHand() {
		int x = 0;

		for (Card cards : player.getHand()) {
			cards.getPicture().setLocation((202 * x) + 400, 720);
			program.add(cards.getPicture());
			x++;
		}

		/*
		x = 0;
		for (Card cards : enemy.getHand()) {
			cards.getPicture().setLocation((101 * x) + 900, 0);
			cards.getPicture().setSize(100, 200);
			program.add(cards.getPicture());
			x++;
		}
		*/
	}
	
	public void changeEntityStats(Entity entity, int amt, boolean isHealth, boolean isVisible) {
		boolean isPositive = amt > 0;
		
		if (isHealth) {
			int newHp = entity.getHp() + amt;
			if (newHp > entity.getMaxHp())
				newHp = entity.getMaxHp();
			if (newHp < 0)
				newHp = 0;
					
			entity.setHp(newHp);
			
			if (entity instanceof Player) {
				playerHealthDamageBar.setSize((entity.getHp()*PLAYER_BAR_WIDTH)/entity.getMaxHp(), playerHealthDamageBar.getHeight());
				playerHealthText.setLabel(entity.getHp() + "/" + entity.getMaxHp());
			} else {
				enemyHealthBar.setSize((entity.getHp()*ENEMY_BAR_WIDTH)/entity.getMaxHp(), enemyHealthBar.getHeight());
			}
		} else {
			int newMana = entity.getMana() + amt;
			if (newMana > entity.getMaxMana())
				newMana = entity.getMaxMana();
			if (newMana < 0)
				newMana = 0;
					
			entity.setMana(newMana);
			
			if (entity instanceof Player) {
				playerManaUseBar.setSize((entity.getMana()*PLAYER_BAR_WIDTH)/entity.getMaxMana(), playerManaUseBar.getHeight());
				playerManaText.setLabel(entity.getMana() + "/" + entity.getMaxMana());
			}
		}
		
		if (isVisible && amt != 0) {
			new Thread() {
		        public void run() {
		        	GLabel statLabel;
		        	
		        	if (isPositive) {
		        		statLabel = new GLabel("+" + amt);
		        		if (isHealth) {
			        		statLabel.setColor(Color.GREEN);
		        		} else {
		        			statLabel.setColor(Color.BLUE);
		        		}
		        	} else {
		        		statLabel = new GLabel("" + amt);
		        		if (isHealth) {
		        			statLabel.setColor(Color.RED);
		        		} else {
		        			statLabel.setColor(Color.MAGENTA);
		        		}
		        	}
		        	
		        	statLabel.setFont(statsFont);
		        	if (entity instanceof Player) {
		        		if (isHealth) {
		        			statLabel.setLocation(400, 50);
		        		} else {
		        			statLabel.setLocation(400, 132);
		        		}
		        	} else {
		        		if (isHealth) {
		        			statLabel.setLocation(1050, 640);
		        		} else {
		        			statLabel.setLocation(1050, 660);
		        		}
		        	}
		        	program.add(statLabel);
		    		
		    		for (int x = 0; x < 30; x++) {
		    			statLabel.move(0, 1);
		    			program.pause(30);
		    		}
		    		
		    		program.remove(statLabel);
		        }
		    }.start();
		}
	}
		
	@Override
	public void mousePressed(MouseEvent e) {
		if (!enemy.isDead() && !player.isDead()) {
			GImage currElem = null;
			
			if (program.getElementAt(e.getX(), e.getY()) instanceof GImage)
				currElem = (GImage) program.getElementAt(e.getX(), e.getY());
			
			if (isPlayerTurn) {
				if (currElem == endTurnButton) {
					new Thread() {
						public void run() {
							playEnemyTurn();
						}
					}.start();
					
					//todo hide statlabel?
					changeEntityStats(player, player.getMaxMana() - player.getMana(), false, false);
					
					return;
				}
				for (Card cards : player.getHand()) {
					if (currElem == cards.getPicture()) {
						if (player.getMana() - cards.getMana() >= 0) {
							cards.play(this, isPlayerTurn, player, enemy);
							
							player.getDeck().add(cards);
							program.remove(cards.getPicture());
							
							player.getHand().remove(cards);
							
							checkIfDead();
							
							changeEntityStats(player, -cards.getMana(), false, true);
						}
						break;
					}
				}
			}
		}
	}
	
	public void playEnemyTurn() {
		isPlayerTurn = false;

		enemy.drawCard();
		reloadHand();
		
		increaseTurn();
		program.pause(2000);

		if (program.getCurScreen().equals(this)) {
			Card randomEnemyCard = enemy.getHand().get(new Random().nextInt(enemy.getHand().size()));
			randomEnemyCard.play(this, isPlayerTurn, player, enemy);
			
			checkIfDead();
			
			program.remove(randomEnemyCard.getPicture());
			enemy.getDeck().add(randomEnemyCard);
			enemy.getHand().remove(randomEnemyCard);
	
			player.drawCard();
			reloadHand();
			
			isPlayerTurn = true;
			increaseTurn();
		}
	}
	
	private void loadPlayerSprite() {
		player.getSprite().setLocation(0, 480);
		player.getSprite().setSize(400, 600);
	}

	@Override
	public void showContents() {
		program.add(background);

		program.add(enemy.getSprite());
		program.add(player.getSprite());
		
		program.add(enemyHealthBar);
		//program.add(enemyArmorBar);

		program.add(playerHealthBar);
		program.add(playerHealthDamageBar);
		program.add(playerHealthText);
		
		program.add(playerManaBar);
		program.add(playerManaUseBar);
		program.add(playerManaText);
		
		program.add(endTurnButton);
		
		program.add(turnText);
		
		
		loadPlayerSprite();
		
		reloadHand();
	}

	@Override
	public void hideContents() {
		program.remove(background);
		
		program.remove(enemyHealthBar);
		//program.remove(enemyArmorBar);

		program.remove(playerHealthBar);
		program.remove(playerHealthDamageBar);
		program.remove(playerHealthText);
		
		program.remove(playerManaBar);
		program.remove(playerManaUseBar);
		program.remove(playerManaText);
		
		program.remove(endTurnButton);
		
		program.remove(turnText);
		
		program.remove(enemy.getSprite());
		for (Card cards : player.getHand()) {
			program.remove(cards.getPicture());
		}
		
		for (Card cards : enemy.getHand()) {
			program.remove(cards.getPicture());
		}
		
		player.resetDeck();
		enemy.resetDeck();
		enemy.setHp(enemy.getMaxHp());
		enemy.setMana(enemy.getMaxMana());
		
		program.remove(player.getSprite());
	}
	
}
