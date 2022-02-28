package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class Revive extends Card {

	public Revive() {
		super(new GImage("media/images/cards/ReviveCard.png"), "Revive", 7, 200);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.changeEntityStats(player, 10, true, true);
		} else {
			bG.changeEntityStats(enemy, 10, true, true);
		}
	}

}
