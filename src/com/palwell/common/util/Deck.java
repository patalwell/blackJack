package com.makesrc.common.util;

import com.makesrc.common.util.Card;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @Author Pat Alwell
 *
 * Deck.java
 *
 * Composite deck of cards and methods for dealing cards in blackJack
 */

public class Deck {

    private ArrayList<Card> deckOfCards;

    //Constructor for our deck.
    //Creates an ArrayList of type String for display
    public Deck() {
        this.deckOfCards = new ArrayList<>();
    }

    public void createDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                Card card = new Card(cardSuit, cardValue);
                this.deckOfCards.add(card);
            }
        }
    }

    //shuffle the deck using Collections
    public void shuffle() {

         Collections.shuffle(deckOfCards);
    }


    public Card dealNextCard() {
        return this.deckOfCards.get(0);
    }

    public void removeCardFromDeck() {
        deckOfCards.remove(0);
    }


    public int generateValue() {

        for (Card card : deckOfCards) {
            int totalValue = 0;
            int ace = 0;

            switch (card.getValue()) {
                case ACE:
                    ace += 1;
                    break;
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
            }
            //If we have more than 1 ace in a hand and the totalValue is greater than 10; each ace is worth 1
            for (int aceQuantity = 0; aceQuantity < ace; aceQuantity++) {

                if (totalValue > 10) {
                    totalValue += 1;
                }
                //Otherwise Aces are worth 11
                else {
                    totalValue += 11;
                }
            }

            return totalValue;
        }
        return 0;
    }
}

