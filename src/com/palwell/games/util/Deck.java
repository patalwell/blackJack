package com.palwell.games.util;

import java.util.ArrayList;
import java.util.Collections;
import com.palwell.games.util.Value;
import com.palwell.games.util.Card;
import com.palwell.games.util.Suit;

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
    //Creates an ArrayList of type Card, loads said ArrayList, and randomizes
    //sequence of cards
    public Deck() {
        this.deckOfCards = new ArrayList<>();
        //Generate our deck with Cards
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                Card card = new Card(cardSuit, cardValue );
                this.deckOfCards.add(card);
                //Shuffle the deck
                Collections.shuffle(deckOfCards);
            }
        }
    }

    public Card dealNextCard() {
        return this.deckOfCards.get(0);
    }

    public void removeCardFromDeck() {
        deckOfCards.remove(0);
    }
}
