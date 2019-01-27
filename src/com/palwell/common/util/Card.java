package com.makesrc.common.util;

/**
 * @Author Pat Alwell
 *
 * Card.java
 *
 * Card class to instantiate cards with both Suits and Values
 */

public class Card {

    //One of the Four Suits in a Deck
    private Suit suit;
    //Values in our deck
    private Value value;

    public Card(Suit cardSuit, Value cardValue) {
        this.suit = cardSuit;
        this.value = cardValue;
    }

    //Getters for Cards and Suits
    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    //Display the value of our card e.g. "Two of Hearts"
    @Override
    public String toString() {
        return value.toString() + " of " + suit.toString();
    }
}



