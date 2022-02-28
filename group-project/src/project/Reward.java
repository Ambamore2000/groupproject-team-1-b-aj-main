package project;

import acm.graphics.GRect;

public class Reward {
	
	Player player;
	int gold;
	Card card;
	
	public Reward(Player player, int gold, Card card) {
		this.player = player;
		this.gold = gold;
		this.card = card;
	}
	
	public void giveReward() {
		player.setGold(player.getGold() + gold);
		player.addCard(card);
	}
	
	public int getGold() {
		return gold;
	}
	
	public Card getCard() {
		return card;
	}

}
