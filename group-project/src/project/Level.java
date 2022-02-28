package project;
import acm.graphics.GImage;

//ANDREW

public class Level {

	private GImage levelImage;
	private int levelNumber;
	private Enemy enemy;
	private boolean complete;
	private Reward reward;
	
	public Level(GImage levelImage, int levelNumber, Enemy enemy, boolean complete, Reward reward) {
		this.levelImage = levelImage;
		this.levelNumber = levelNumber;
		this.enemy = enemy;
		this.complete = complete;
		this.reward = reward;
	}
	
	public GImage getLevelImage() {
		return levelImage;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	public void setComplete() {
		this.complete = true;
	}
	
	public Reward getReward() {
		return reward;
	}
	
}
