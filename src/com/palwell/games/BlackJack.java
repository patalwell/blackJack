package com.palwell.games;

import com.palwell.games.util.Card;
import com.palwell.games.util.Hand;
import com.palwell.games.util.Value;
import com.palwell.games.util.Test;
import java.util.Scanner;

/**
 * @Author Pat Alwell
 *
 * BlackJack.java
 *
 * Driver for our blackJack simulator. Simulator prompts player if they want
 * to play a game and exists if they don't. Simulator deals a hand for both
 * the dealer and the player and prompts the player if they'd like to hit or
 * stand. It there is an ace in the hand and the value is less than 21 the
 * program will print calculated values for an Ace being a 1 or 11.
 * The dealer cannot hit if the dealer's hand is >= 17. Program ends with a
 * clear winner or a push and asks the user if they's like to play again.
 */

public class BlackJack {

    public static void main(String[] args) {
        //Get Console Input
        Scanner scanner = new Scanner(System.in);
        //Game Prompt
        System.out.println("Shall we play a game? ( Y or N): ");
        String userInput = scanner.next();
        while (userInput.toLowerCase().equals("y")) {

            //Generate a hand for the dealer and the player
            Hand dealersHand = new Hand();
            Hand playersHand = new Hand();

            //Test Class to debug Ace Logic
//            Test dealersHand = new Test();
//            Test playersHand = new Test();

            /**
             * Start Logic for Dealers's Hand
             * Deals 2 cards and calculates hand value
             */
            System.out.println("\nDealer's Hand: " + dealersHand);
            int dealerValue = dealersHand.generateHandValue();
            //Flag for Aces in Hand
            boolean dealerHasAce = false;
            //Provide an alternate value e.g. total with 1 or 11
            int tempDealerValue = 0;
            //Check the hand for an ACE
            for (Card dealersCard : dealersHand.getCurrentHand()) {
                if (dealersCard.getValue() == Value.ACE && dealerValue <= 21) {
                    tempDealerValue = dealerValue - 10;
                    dealerHasAce = true;
                }
                if (dealersCard.getValue() == Value.ACE && dealerValue > 21){
                    dealerValue -=10;
                }
            }
                //Display Value of Dealer's Hand with Ace as 11 or 1
                //Flag for an Ace and Show either Value otherwise ignore the
                // flag
                if (dealerHasAce) {
                    System.out.println("Current value of Dealer's Hand: " + tempDealerValue + " or " + dealerValue);
                } else {
                    System.out.println("Current value of Dealer's Hand: " + dealerValue);

                }
                /**
                 * Start Logic for Player's Hand
                 */
                //Print Player's Hand
                System.out.println("\nPlayer's Hand: " + playersHand);
                //Print Value of Player's Hand
                int playerValue = playersHand.generateHandValue();
                //Flag for Aces in Hand
                boolean playerHasAce = false;
                //Provide an alternate value e.g. total with 1 or 11
                int tempPlayerValue = 0;
                //Check the hand for an ACE
                for (Card playersCard : playersHand.getCurrentHand()) {
                    if (playersCard.getValue() == Value.ACE && playerValue <=21) {
                        tempPlayerValue = playerValue - 10;
                        playerHasAce = true;
                    }
                    if (playersCard.getValue() == Value.ACE && playerValue > 21) {
                        playerValue -= 10;
                    }

                }
            //Display Value of Player's Hand with Ace as 11 or 1
            //Flag for an Ace and Show either Value
            if (playerHasAce) {
                System.out.println("Current value of Player's Hand: " + tempPlayerValue + " or " + playerValue);
            } else {
                System.out.println("Current value of Players's Hand: " + playerValue);
            }


            //See if Player wants to Hit or Stand
            System.out.println("\n(H) for hold, (D) for deal a new card");
            String playerInput = scanner.next();
            /**
             * Dealing Logic for Player
             *
             * Set Hand with ACES to test logic
             */
            while (playerInput.toLowerCase().equals("d")) {
                //Next Card for Player and Remove Card from Deck
                playersHand.dealCard();
                //Display players current hand
                System.out.println("\nPlayer's Hand: " + playersHand);
                //Display current value of hand
                playerValue = playersHand.generateHandValue();
                //Flag for Aces in Hand
                playerHasAce = false;
                //Provide an alternate value e.g. total with 1 or 11
                tempPlayerValue = 0;
                //Check the hand for an ACE
                for (Card playersCard : playersHand.getCurrentHand()) {
                    if (playersCard.getValue() == Value.ACE && playerValue <= 21) {
                        tempPlayerValue = playerValue - 10;
                        playerHasAce = true;
                    }
                    if (playersCard.getValue() == Value.ACE && playerValue > 21) {
                        playerValue -= 10;
                    }

                }
                //Display Value of Player's Hand with Ace as 11 or 1
                //Flag for an Ace and Show either Value
                if (playerHasAce) {
                    System.out.println("Current value of Player's Hand: " + tempPlayerValue + " or " + playerValue);
                } else {
                    System.out.println("Current value of Players's Hand: " + playerValue);
                }

                //Exit our loop if Player busts
                if (playerValue > 21) {
                    System.out.println("Player busts!");
                    break;
                }
                //Display if the player has blackjack and exit our loop
                if (playerValue == 21) {
                    System.out.println("\nPlayer has BlackJack!");
                    break;
                }
                //prompt if the player wants to hit or stay
                System.out.println("\n(H) for hold, (D) for deal a new card");
                playerInput = scanner.next();
            }
            /**
             * Dealing Logic for Dealer
             *
             * Set Hand with ACES to test logic
             */
            while (dealerValue < 17) {
                //Next card for dealer and remove card from deck
                dealersHand.dealCard();
                //Display dealers  hand
                System.out.println("\nDealer's Hand: " + dealersHand);
                //Total card values
                dealerValue = dealersHand.generateHandValue();
                //Flag for Aces in Hand
                dealerHasAce = false;
                //Provide an alternate value e.g. total with 1 or 11
                tempDealerValue = 0;
                //Check the hand for an ACE
                for (Card dealersCard : dealersHand.getCurrentHand()) {
                    if (dealersCard.getValue() == Value.ACE && dealerValue <= 21) {
                        tempDealerValue = dealerValue - 10;
                        dealerHasAce = true;
                    }
                    if (dealersCard.getValue() == Value.ACE && dealerValue > 21){
                        dealerValue -=10;
                    }
                }
                //Display Value of Dealer's Hand with Ace as 11 or 1
                //Flag for an Ace and Show either Value otherwise ignore the
                // flag
                if (dealerHasAce) {
                    System.out.println("Current value of Dealer's Hand: " + tempDealerValue + " or " + dealerValue);
                } else {
                    System.out.println("Current value of Dealer's Hand: " + dealerValue);

                }

                //Dealer gets 21
                if (dealerValue == 21) {
                    System.out.println("\nDealer Has BlackJack!");
                    break;
                }
                //Dealer busts exit our loop
                if (dealerValue > 21) {
                    System.out.println("Dealer Busts!");
                    break;
                }
            }
            /**
             * Determine the games results
             */
            if (dealerValue == playerValue) {
                System.out.println("\nNeither the dealer nor the play win. " +
                        "It's a Push!");
            }
            if (playerValue > 21 && dealerValue <= 21) {
                System.out.println("Dealer Wins!");
            }
            if (dealerValue > 21 && playerValue <= 21) {
                System.out.println("Player Wins!");
            }
            if (dealerValue <= 21 && dealerValue > playerValue) {
                System.out.println("Dealer Wins!");
            }
            if (playerValue <= 21 && playerValue > dealerValue) {
                System.out.println("Players wins!");
            }
            if (playerValue > 21 && dealerValue > 21) {
                System.out.println("\nNeither the dealer nor the play win. " +
                        "It's a Push!");
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
