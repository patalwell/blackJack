package com.makesrc;

import com.makesrc.common.util.Deck;
import com.makesrc.common.util.Card;
import com.makesrc.common.util.Value;

import java.util.Scanner;


// Calculate an Ace as a 1 or 11


public class BlackJack {


    public static void main(String[] args) {
        //Get Console Input
        Scanner scanner = new Scanner(System.in);

        //Ask if the User wants to play a game
        //If not exit the application
        System.out.println("Shall we play a game? ( Y or N): ");
        String userInput = scanner.next();
        while (userInput.toLowerCase().equals("y")) {

            //Generate a hand for the dealer and the player
            Deck deck = new Deck();

            deck.createDeck();

            //Randomize our deck
            deck.shuffle();


            //Deal two cards to the dealer and remove the cards from the deck
            Card dealersFirstCard = deck.dealNextCard();
            deck.removeCardFromDeck();
            Card dealersSecondCard  = deck.dealNextCard();
            deck.removeCardFromDeck();


            //Build and display dealer's Hand
            StringBuilder dealersHand = new StringBuilder();
            dealersHand.append(dealersFirstCard.toString()).append(", ").append(dealersSecondCard.toString());
            System.out.println("\nDealer's Hand: " + dealersHand);
            //Print Value of Dealer's Hand

//            int dealerValue =
//                    deck.generateValue(dealersFirstCard) + deck.generateValue(dealersSecondCard);

            int dealerValue = deck.generateValue();












            System.out.println("Current value of Dealer's Hand: " + dealerValue);

            //Deal two cards to the player and remove the cards from the deck
            Card playersFirstCard = deck.dealNextCard();
            deck.removeCardFromDeck();
            Card playersSecondCard  = deck.dealNextCard();
            deck.removeCardFromDeck();

            //Print Player's Hand
            StringBuilder playersHand = new StringBuilder();
            playersHand.append(playersFirstCard.toString()).append(", ").append(playersSecondCard.toString());
            System.out.println("\nPlayer's Hand: " + playersHand);
//            int playerValue =
//                    deck.generateValue(playersFirstCard) + deck.generateValue(playersSecondCard);

            int playerValue = deck.generateValue();

            //Print Value of Player's Hand
            System.out.println("Current value of Player's Hand: " + playerValue);

            //See if Player wants to Hit or Stand
            System.out.println("\n(H) for hold, (D) for deal a new card");
            String playerInput = scanner.next();

            while (playerInput.toLowerCase().equals("d")) {
                //Next Card for Player
                Card playersNextCard = deck.dealNextCard();
                //Append Card to player's hand
                playersHand.append(", ").append(playersNextCard.toString());
                //Remove the card from the deck
                deck.removeCardFromDeck();
                //Display players aggregate hand
                System.out.println("\nPlayer's Hand: " + playersHand);
                //Total value of hand
                playerValue += deck.generateValue();
                //Display current value of hand
                System.out.println("Current value of Player's Hand: " + playerValue);

                //Display a loss for the player if the player busts
                if (playerValue > 21) {
                    System.out.println("\nPlayer Busts, Dealer Wins!");
                    break;
                }
                //Display if the player has blackjack
                if (playerValue == 21) {
                    System.out.println("\nPlayer has BlackJack!");
                    break;
                }
                //prompt if the player wants to hit or stay
                System.out.println("\n(H) for hold, (D) for deal a new card");
                playerInput = scanner.next();
            }


            //Dealer Rules for BlackJack; needs to hit till 17
            while (dealerValue < 17) {
                //Next card for dealer
                Card dealersNextCard = deck.dealNextCard();
                //Append card to dealer's hand
                dealersHand.append(", ").append(dealersNextCard.toString());
                //Remove card from deck
                deck.removeCardFromDeck();
                //Display dealers aggregate hand
                System.out.println("\nDealer's Hand: " + dealersHand);
                //Total card values
                dealerValue += deck.generateValue();
                //Display current value
                System.out.println("Current value of Dealer's Hand: " + dealerValue);

                //Dealer gets 21
                if (dealerValue == 21) {
                    System.out.println("\nDealer Has BlackJack!");
                    break;
                }

                //Dealer busts
                if (dealerValue > 21) {
                    System.out.println("\nDealer Busts, Player Wins!");
                    break;
                }
            }

            //Determine our winner
            if (dealerValue == playerValue) {
                System.out.println("\nNeither the dealer nor the play win. " +
                        "It's" +
                        " a Push!");
            }

            if (dealerValue > playerValue && dealerValue <= 21) {
                System.out.println("\nThe dealer has a higher hand. The " +
                        "dealer " +
                        "wins!");
            }

            if (dealerValue < playerValue && playerValue <= 21) {
                System.out.println("\nThe player has a higher hand. Player " +
                        "wins!");
            }

            //Prompt if the user still wants to play
            System.out.println("\nShall we play a game? ( Y or N): ");
            userInput = scanner.next();

        }

        //Else exit the application
        System.out.println("Bye!");
        System.exit(0);
    }
}
