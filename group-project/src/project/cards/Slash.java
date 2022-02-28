package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class Slash extends Card {

	public Slash() {
		super(new GImage("media/images/cards/SlashCard.png"), "Slash", 4, 100);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.changeEntityStats(enemy, -3, true, true);
		} else {
			bG.changeEntityStats(player, -3, true, true);
		}
	}

}
