package com.richiecodes;

import player.Player;

public class Main {

    public static void main(String[] args) {
        //TODO: Create Player/Dealer class
	    Player player1 = new Player("Richie", 1000);
	    player1.showPlayerInfo();
		System.out.println("\n");
	    player1.showPlayerDeck();
    }
}
