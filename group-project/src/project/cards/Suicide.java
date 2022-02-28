package project.cards;	

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Player;

public class Suicide extends Card {
	
	public Suicide() {	
		super(new GImage("media/images/cards/SuicideCard.png"), "Suicide", 6, 300);
	}
	
	@Override	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {	
		if (isPlayerTurn) {
			bG.changeEntityStats(player, -5, true, true);
			bG.changeEntityStats(enemy, -10, true, true);
		} else {
			bG.changeEntityStats(enemy, -5, true, true);
			bG.changeEntityStats(player, -10, true, true);
		}
	}

}