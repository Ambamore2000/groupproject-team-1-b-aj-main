package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;
import starter.GraphicsPane;

public class LargeHealthPotion extends Card {

	public LargeHealthPotion() {
		super(new GImage("media/images/cards/LargeHealthPotionCard.png"), "Large Health Potion", 4, 100);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.changeEntityStats(player, 5, true, true);
		} else {
			bG.changeEntityStats(enemy, 5, true, true);
		}
	}
	
	
}
