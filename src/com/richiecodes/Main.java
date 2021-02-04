package com.richiecodes;

import cards.Deck;

public class Main {

    public static void main(String[] args) {
        //TODO: Create Player/Dealer class
	    Deck myDeck = new Deck();
        System.out.println(myDeck);
        System.out.println();
        System.out.println();
        myDeck.shuffle();
        System.out.println(myDeck);
    }
}
