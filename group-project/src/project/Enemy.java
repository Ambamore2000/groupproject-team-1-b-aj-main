package project;

import java.util.ArrayList;

import acm.graphics.GImage;

//ignore
public class Enemy extends Entity {
	private String name;

	public Enemy(String name, GImage sprite, int hp, int maxHp, int mana, int maxMana, ArrayList<Card> deck) {
		super(sprite, hp, maxHp, mana, maxMana, deck);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
