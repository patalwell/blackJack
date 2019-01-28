package com.palwell.games.util;

import java.util.ArrayList;

import com.palwell.games.util.Value;
import com.palwell.games.util.Card;
import com.palwell.games.util.Deck;
import com.palwell.games.util.Suit;
/**
 * @Author Pat Alwell
 *
 * Hand.java
 *
 * Hand Object to remove cards from our deck and add them to a player's or
 * dealer's hand
 */
public class Hand {

    private ArrayList<Card> currentHand;
    private Deck deck = new Deck();

    //Constructor for Hand adds two cards to each hand and removes them from
    // the deck
    public Hand() {
        this.currentHand = new ArrayList<>();
        currentHand.add(deck.dealNextCard());
        deck.removeCardFromDeck();
        currentHand.add(deck.dealNextCard());
        deck.removeCardFromDeck();
    }


    //Removes Array Brackets for console output
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card value : currentHand) {
            stringBuilder.append(value).append(", ");
        }
        return stringBuilder.toString();
    }

    public void dealCard() {
        currentHand.add(deck.dealNextCard());
        deck.removeCardFromDeck();
    }

    public ArrayList<Card> getCurrentHand() {
        return currentHand;
    }

    public int generateHandValue() {
        int totalValue = 0;
        /**
         * Iterate through the dealer or player's current hand and look for
         * values
         */
        for (Card card : currentHand) {

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
