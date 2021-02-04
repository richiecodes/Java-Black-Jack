package player;

import cards.Deck;

public class Player {
    private Deck deck = new Deck();
    private String name;
    private int chips;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        deck.shuffle();
    }

    public void showPlayerDeck() {
        System.out.println(this.deck);
    }

    public String getName() {
        return this.name;
    }

    public int getChips() {
        return this.chips;
    }

    public void showPlayerInfo() {
        System.out.println(name + "\t" + "Chips: " + chips);
    }

}
