package RandomCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Write a programme to shuffle a deck of 52 cards,
 * and shuffle them equallay to 4 players
 */
class Card {
	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	private final Rank rank;
	private final Suit suit;

	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return rank;
	}

	public Suit suit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	private static final List<Card> protoDeck = new ArrayList<Card>();

	// Initialize prototype deck
	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				protoDeck.add(new Card(rank, suit));
	}

	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
	}
}

public class RandomCards {
	public static void main(String[] args) {
		ArrayList<Card> player1 = new ArrayList<Card>();
		ArrayList<Card> player2 = new ArrayList<Card>();
		ArrayList<Card> player3 = new ArrayList<Card>();
		ArrayList<Card> player4 = new ArrayList<Card>();

		ArrayList<Card> deck = Card.newDeck();
		Random random = new Random();
		int j = 1;
		for (int i = 0; i < 52; i++) {
			int temp = random.nextInt(52);
			if (j == 1) {
				player1.add(deck.get(temp));
				j++;
				continue;
			} else if (j == 2) {
				player2.add(deck.get(temp));
				j++;
				continue;
			} else if (j == 3) {
				player3.add(deck.get(temp));

				j++;
				continue;
			} else if (j == 4) {
				player4.add(deck.get(temp));
				j = 1;
				continue;
			}
		}
		System.out.println(" Player 1 " + player1);
		System.out.println(" Player 2 " + player2);
		System.out.println(" Player 3 " + player3);
		System.out.println(" Player 4 " + player4);
	}
}