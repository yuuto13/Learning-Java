package Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Card {
	public static void main(String[] args) {
		Card[] cards = new Card[52];
		for(Suit suit : Suit.values()) {
			for (int n = 1; n <= 13; n++) {
				int index = suit.ordinal() * 13 + n - 1;
				cards[index] = new Card(suit, n);
			}
		}
		List<Card> deckofCards = Arrays.asList(cards); //make a deck of 52 cards
		Collections.shuffle(deckofCards); //shuffle the cards
		List<Card> hand = deckofCards.subList(0, 5); //draw a hand of 5 cards
		System.out.println(hand); //display hand
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(deckofCards); //shuffle the cards
			List<Card> hands = deckofCards.subList(0, 5); //draw a hand of 5 cards
			System.out.println(hand); //display hand
		}
		/*
		 * [Two of Spades, Three of Diamonds, The Four of Clubs, The Five of Spades, The Six of Clubs]
		 * [Jack of Clubs, The Queen of Hearts, Queen of Diamonds, The Two of Spades, The Jack of Spades]
		 * [Five of Diamonds, The Four of Clubs, Five of Hearts, The Five of Spades, The Ace of Hearts]
		 * [King of Spades, King of Clubs, The Four of Diamonds, King of Hearts, The Queen of Spades]
		 */
	}
	
	public enum Suit {
		Diamond, Club, Heart, Spade
	}
	Suit suit;
	int number;
	
	public Card(Suit suit, int number) {
		this.setSuit(suit);
		this.setNumber(number);
	}
	
	public String toString() {
		String numberName = "";
		switch (number) {
		case 1:
			numberName = "Ace";
			break;
		case 2:
			numberName = "Two";
			break;
		case 3:
			numberName = "Three";
			break;
		case 4:
			numberName = "Four";
			break;
		case 5:
			numberName = "Five";
			break;
		case 6:
			numberName = "Six";
			break;
		case 7:
			numberName = "Seven";
			break;
		case 8:
			numberName = "Eight";
			break;
		case 9:
			numberName = "Nine";
			break;
		case 10:
			numberName = "Ten";
			break;
		case 11:
			numberName = "Jack";
			break;
		case 12:
			numberName = "Queen";
			break;
		case 13:
			numberName = "King";
			break;
		}
		return "The " + numberName + " of " + suit + "s";
	}
	public int compareTo(Object obj) {
		return Objects.compare(this, obj, null);
	}
	public int compareTo(Card card) {
		if(this.getSuitNumber() > card.getSuitNumber()) {
			return 1;
		}
		else if(this.getSuitNumber() < card.getSuitNumber()) {
			return -1;
		}
		if(this.getNumber() > card.getNumber()) {
			return 1;
		}
		else if(this.getNumber() < card.getNumber()) {
			return -1;
		}
		return 0;
	}
	
	public int getSuitNumber() { return suit.ordinal(); }
	public int getNumber() { return number; }
	public void setNumber(int number) {
		if(number > 13) this.number = 13;
		else if(number < 1) this.number = 1;
		else this.number = number;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
