package project;

import acm.graphics.GImage;

public class Card {


	
	//public string getName;
	enum type{
		ATTACK,
		EQUIP,
		ACTION,
		MANA,
		HEALING
	}

	public static final String cards = null;
	public static int length;


	private GImage picture;
	private String name;
	private int mana;
	private int cost;
	
	public Card(GImage picture, String name, int mana, int cost) {
		this.picture = picture;
		this.name = name;
		this.mana = mana;
		this.cost = cost;
	}

	public boolean canPlay(Entity user, Entity target) {//Function to test if card is playable (can pay mana cost, can target entity, etc)

		return true;
	}

	public GImage getPicture() {
		return picture;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		
	}
	
}

