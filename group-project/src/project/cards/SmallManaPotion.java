package project.cards;	

import acm.graphics.GImage;	
import project.BoardGraphics;	
import project.Card;	
import project.Enemy;	
import project.Entity;	
import project.Player;	

public class SmallManaPotion extends Card {	

	public SmallManaPotion() {
		super(new GImage("media/images/cards/SmallManaPotionCard.png"), "Small Mana Potion", 0, 50);
	}	

	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {	
			bG.changeEntityStats(player, 2, false, true);	
		} else {	
			bG.changeEntityStats(enemy, 2, false, true);	
		}	
	}	

}