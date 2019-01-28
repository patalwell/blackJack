package com.palwell.games.util;

import java.util.ArrayList;

import com.palwell.games.util.Value;
import com.palwell.games.util.Card;
import com.palwell.games.util.Suit;
import com.palwell.games.util.Deck;

public class Test {

    private ArrayList<Card> testHand;
    private Deck deck = new Deck();

    /**
     * Test for ACES
     */
    private Card ace1 = new Card(Suit.CLUBS,Value.ACE);
    private Card ace2 = new Card(Suit.SPADES,Value.ACE);
    private Card ace3 = new Card(Suit.DIAMONDS,Value.ACE);
    private Card ace4 = new Card(Suit.CLUBS, Value.ACE);
    private Card two = new Card(Suit.DIAMONDS, Value.TWO);
    private Card nine = new Card(Suit.SPADES, Value.NINE);

    public Test() {
        this.testHand = new ArrayList<>();
        testHand.add(ace1);
        testHand.add(ace2);
        testHand.add(ace3);
        testHand.add(ace4);
        testHand.add(two);
        testHand.add(nine);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card value : testHand) {
            stringBuilder.append(value).append(", ");
        }
        return stringBuilder.toString();
    }

    public void dealCard() {
        testHand.add(deck.dealNextCard());
        deck.removeCardFromDeck();
    }

    public ArrayList<Card> getCurrentHand() {
        return testHand;
    }

        public int generateHandValue() {
            int totalValue = 0;
            /**
             * Iterate through the dealer or player's current hand and look for
             * values
             */
            for (Card card : testHand) {

                switch (card.getValue()) {
                    case TWO:
                        totalValue += 2;
                        break;
                    case THREE:
                        totalValue += 3;
                        break;
                    case FOUR:
                        totalValue += 4;
                        break;
                    case FIVE:
                        totalValue += 5;
                        break;
                    case SIX:
                        totalValue += 6;
                        break;
                    case SEVEN:
                        totalValue += 7;
                        break;
                    case EIGHT:
                        totalValue += 8;
                        break;
                    case NINE:
                        totalValue += 9;
                        break;
                    case TEN:
                        totalValue += 10;
                        break;
                    case JACK:
                        totalValue += 10;
                        break;
                    case QUEEN:
                        totalValue += 10;
                        break;
                    case KING:
                        totalValue += 10;
                        break;
                    case ACE:
                        totalValue += 11;
                        break;
                }

            }
            return totalValue;
        }

}
