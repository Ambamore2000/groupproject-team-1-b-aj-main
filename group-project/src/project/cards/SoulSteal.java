package project.cards;	

import acm.graphics.GImage;	
import project.BoardGraphics;	
import project.Card;	
import project.Enemy;	
import project.Entity;	
import project.Player;	

public class SoulSteal extends Card {	

	public SoulSteal() {	
		super(new GImage("media/images/cards/SoulStealCard.png"), "Soul Steal", 8, 400);	
	}	

	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {	
			bG.changeEntityStats(player, 5, true, true);	
			bG.changeEntityStats(enemy, -5, true, true);	
		} else {	
			bG.changeEntityStats(enemy, 5, true, true);	
			bG.changeEntityStats(player, -5, true, true);	
		}	
	}	

}