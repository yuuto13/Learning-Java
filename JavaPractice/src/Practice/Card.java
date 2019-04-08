package Practice;

import java.util.Arrays;
import java.util.List;

public class Card {
	public static void main(String[] args) {
		Card[] cards = new Card[52];
		List<Card> cardList = Arrays.asList(cards);
	}
	
	public enum Suit {
		Club, Clover, Heart, Spade
	}
	Suit suit;
	int number;
	
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}
}
