package project;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;

public class Entity {
	
	private int hp;
	private int maxHp;
	private int armor;
	private int mana;
	private int maxMana;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	//private ArrayList<Card> discard;
	private GImage sprite;
	Random rand = new Random();
	
	public Entity(GImage sprite, int hp, int maxHp, int mana, int maxMana, ArrayList<Card> deck) {
		this.sprite = sprite;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mana = mana;
		this.maxMana = maxMana;
		this.deck = deck;
		this.hand = new ArrayList<Card>();
		//this.discard = new ArrayList<Card>();
	}
	
	public void setSprite(GImage sprite) {
		this.sprite = new GImage(sprite.getImage());
	}
	
	public GImage getSprite() {
		return sprite;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public int getMaxMana() {
		return maxMana;
	}
	
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	//public void setDiscard(ArrayList<Card> discard) {
	//	this.discard = discard;
	//}
	
	//public ArrayList<Card> getDiscard() {
	//	return discard;
	//}
	
	public void resetDeck() {
		while (!getHand().isEmpty()) {
			Card card = getHand().get(getHand().size() - 1);
			getDeck().add(card);
			getHand().remove(card);
		}
	}
	
	public void drawCard() {
		while (!getDeck().isEmpty() && getHand().size() <= 3) {
			int randCard = new Random().nextInt(getDeck().size());
			getHand().add(getDeck().get(randCard));
			getDeck().remove(randCard);
		}
	}
	
	public boolean isDead() {
		return (hp <= 0);
	}
	
}
 