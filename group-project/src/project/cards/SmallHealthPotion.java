package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class SmallHealthPotion extends Card {

	public SmallHealthPotion() {
		super(new GImage("media/images/cards/SmallHealthPotionCard.png"), "Small Health Potion", 3, 50);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.changeEntityStats(player, 2, true, true);
		} else {
			bG.changeEntityStats(enemy, 2, true, true);
		}
	}

}
