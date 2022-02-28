package project;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
	private int buycards;
	private int sellcards;
	private String cardname;
	private double money;
	private int cardprice;
	private String card;
	public int Card;
	
	public Shop( int buycards, int sellcards) {
		this.buycards = buycards;
		this.sellcards = sellcards;
		this.card = card;
	}
	
	public int getbuycards() {
		return buycards;
	}
	
    public int getsellcards() {
	   return sellcards;
}
    
    public void hasCards( String cardname,int card){  
        this.cardname = cardname;

        if(cardname == "SmallHealthPotion" || cardname == "LargeHealthPotion" || cardname == "Equipment"||cardname == "Revive")
        {
            this.card = cardname;
        }
    } 

    public void buyCards(String cardname, int cardprice, double money) {
    	this.money=money;
    	int PlayerDeck = 0;
    	if(money>cardprice) {
    		System.out.println("You got"+cardname+"card");
    		money=money-cardprice;
    		PlayerDeck=PlayerDeck+1;
    	}
    	if(money<cardprice) {
    		System.out.println("Don't have enough money to buy this"+ cardname+"card");
    		this.money=money;
    		PlayerDeck=PlayerDeck;
    	}
    }
    
    public void sellCards(String cardname, int cardprice, int oldcard) {
    	this.cardprice=cardprice;
        int PlayerDeck = 0;
    	if(Card==oldcard){
    		System.out.println("You sell"+cardname+"card");
    		money=money+cardprice/2;
    		PlayerDeck=PlayerDeck-1;
    	}
    	
    	else {
    		money=money;
    		PlayerDeck=PlayerDeck;
    	}
    	
    }
    }
