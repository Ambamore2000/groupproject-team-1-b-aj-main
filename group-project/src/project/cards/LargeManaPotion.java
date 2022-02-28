package project.cards;	

import acm.graphics.GImage;	
import project.BoardGraphics;	
import project.Card;	
import project.Enemy;	
import project.Entity;	
import project.Player;	

public class LargeManaPotion extends Card {	

	public LargeManaPotion() {
		super(new GImage("media/images/cards/LargeManaPotionCard.png"), "Large Mana Potion", 0, 100);
	}	

	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {	
			bG.changeEntityStats(player, 5, false, true);	
		} else {	
			bG.changeEntityStats(enemy, 5, false, true);	
		}	
	}	

}