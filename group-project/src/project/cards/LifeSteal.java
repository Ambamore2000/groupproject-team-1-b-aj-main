package project.cards;	

import acm.graphics.GImage;	
import project.BoardGraphics;	
import project.Card;	
import project.Enemy;	
import project.Entity;	
import project.Player;	

public class LifeSteal extends Card {	

	public LifeSteal() {	
		super(new GImage("media/images/cards/LifeStealCard.png"), "Life Steal", 4, 200);	
	}	

	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {	
			bG.changeEntityStats(player, 2, true, true);	
			bG.changeEntityStats(enemy, -2, true, true);	
		} else {	
			bG.changeEntityStats(enemy, 2, true, true);	
			bG.changeEntityStats(player, -2, true, true);	
		}	
	}	

}