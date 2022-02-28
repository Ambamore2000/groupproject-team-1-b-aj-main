package project;

import java.util.ArrayList;
import java.util.Arrays;

import project.cards.SmallHealthPotion;
import project.cards.SmallManaPotion;
import project.cards.SoulSteal;
import project.cards.Split;
import project.cards.LargeHealthPotion;
import project.cards.LargeManaPotion;
import project.cards.LifeSteal;
import project.cards.ManaRevive;
import project.cards.Revive;
import project.cards.Stick;
import project.cards.Suicide;
import project.cards.Slash;
import project.cards.Stab;


public class CardPool {
	
	public static ArrayList<Card> getCardList() {
		ArrayList<Card> cardList = new ArrayList<>();
		cardList.add(new SmallHealthPotion());
		cardList.add(new LargeHealthPotion());
		cardList.add(new Revive());
		cardList.add(new Stick());
		cardList.add(new Slash());
		cardList.add(new Stab());
		cardList.add(new SmallManaPotion());
		cardList.add(new LargeManaPotion());
		cardList.add(new ManaRevive());
		cardList.add(new LifeSteal());
		cardList.add(new SoulSteal());
		cardList.add(new Suicide());
		cardList.add(new Split());
		return cardList;
	}
}
