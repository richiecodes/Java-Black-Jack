package com.richiecodes;

import cards.StdDeck;
import player.Dealer;
import player.Player;
import ui.Console;

public class BlackJack {
    Dealer dealer = new Dealer();
    Player player;
    Console console = new Console();
    boolean validPlayerHand = true;
    boolean validDealerHand = true;

    public BlackJack() {
        player = new Player();
        console.cls();
        startNewGame();
    }

    public void startNewGame() {
        dealer.getHand().clear();
        player.getHand().clear();
        dealer.dealHandToSelf();
        dealer.dealHandToPlayer(player);
        validPlayerHand = player.validateHand();
        if(validPlayerHand) {
            System.out.println(String.format("%s's Hand: %s", player.getName(), player.getHand()));
            int sum = 0;
            for (var card : player.getHand()) {
                sum += card.getValue();
            }
            System.out.println("Value: " + sum);
            System.out.println(String.format("%s chips remaining\n\n", player.getChips()));
            player.setPlayerBet(console.getNumber("Enter bet (min 10)", 10, player.getChips()));
            System.out.println(String.format("%s bets %s chips! (%s chips remaining)", player.getName(), player.getPlayerBet(), player.getChips()));
            handleTurn();
        } else {
            System.out.println("GAME OVER");
        }
    }

    private void handleTurn() {
        validPlayerHand = player.validateHand();
        while(validPlayerHand) {
            String hitOrStay = console.getString("Hit or Stay?");

            if (hitOrStay.toLowerCase().equals("hit")) {
                dealer.dealCardToPlayer(player);
                console.cls();
                System.out.println(player.getName() + " draws a " + player.getCard());
                int sum = 0;
                for (var card : player.getHand()) {
                    sum += card.getValue();
                }
                System.out.println("Value: " + sum);
                System.out.println(player.getHand());
                validPlayerHand = player.validateHand();
            } else if (hitOrStay.toLowerCase().equals("stay")) {
                System.out.println("Stay!");
                dealerTurn();
                break;
            }
        }
    }

    private void dealerTurn() {
        dealer.validateHand();

        int sumOfPlayerCards = 0;
        int sumOfDealerCards = 0;

        for(var card : player.getHand()) {
            sumOfPlayerCards += card.getValue();
        }

        for(var card : dealer.getHand()) {
            sumOfDealerCards += card.getValue();
        }

        if(sumOfPlayerCards > sumOfDealerCards && sumOfPlayerCards < 21 || dealer.dealerBust(sumOfDealerCards) || sumOfPlayerCards == 21) {
            System.out.println(player.getName() + " wins! " + (player.getPlayerBet() * 2) + " chips won!");
            player.setChips(player.getChips() + (player.getPlayerBet() * 2));
            player.setPlayerBet(0);
            playAgain();
        }

        if(sumOfDealerCards > sumOfPlayerCards && sumOfPlayerCards < 21) {
            System.out.println(player.getName() + " loses :( " + (player.getPlayerBet() * 2) + " chips lost!");
            player.setChips(player.getChips() - (player.getPlayerBet() * 2));
            if(player.getChips() <= 0) {
                System.out.println("No more chips!");
            }
            player.setPlayerBet(0);
            playAgain();
        }

    }


    private void playAgain() {
        String replay = console.getString("Play another round? (y/n)");
        switch (replay.toLowerCase()) {
            case "y":
                console.cls();
                startNewGame();
                break;

            case "n":
                break;

            default:
                System.out.println("Invalid input...");
        }
    }
}