package com.richiecodes;

import cards.StdDeck;
import player.Dealer;
import player.Player;
import ui.Console;

public class BlackJack {
    Dealer dealer = new Dealer();
    Player player;
    Console console = new Console();
    int playerBet;
    boolean validPlayerHand = true;

    public BlackJack() {
        player = new Player();
        console.cls();
        dealer.dealHandToSelf();
        dealer.dealHandToPlayer(player);
        validPlayerHand = player.validateHand();
        startGame();
    }

    public void startGame() {
        if(validPlayerHand) {
            System.out.println(String.format("%s's Hand: %s", player.getName(), player.getHand()));
            System.out.println(String.format("%s chips remaining\n\n", player.getChips()));
            getPlayerBet();
            System.out.println(String.format("%s bets %s chips! (%s chips remaining)", player.getName(), playerBet, player.getChips()));
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
                System.out.println(player.getHand());
                validPlayerHand = player.validateHand();
            } else {
                System.out.println("Stay!");
            }
        }
    }

    private void getPlayerBet() {
        playerBet = console.getNumber("Enter bet (min 10)", 10, player.getChips());
        player.setChips(player.getChips() - playerBet);
    }

}
