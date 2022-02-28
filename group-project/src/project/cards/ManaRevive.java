package project.cards;	

import acm.graphics.GImage;	
import project.BoardGraphics;	
import project.Card;	
import project.Enemy;	
import project.Entity;	
import project.Player;	

public class ManaRevive extends Card {	

	public ManaRevive() {
		super(new GImage("media/images/cards/ManaReviveCard.png"), "Mana Revive", 0, 200);
	}	

	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {	
			bG.changeEntityStats(player, 10, false, true);	
		} else {	
			bG.changeEntityStats(enemy, 10, false, true);	
		}	
	}	

}