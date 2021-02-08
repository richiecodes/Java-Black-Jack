package cards;

import ui.Console;

public class RiggedDeck implements Deck {

    private final String[] SUITS = {"♤", "♥", "♧", "♦"};

    public void shuffle() {
        return;
    }

    public Card draw() {
        Console console = new Console();
        int value = console.getNumber("What Card value 1-13", 1, 13);
        int suit = console.getNumber("What Suit 1-4", 1, 4);

        return new Card(SUITS[suit - 1], value);
    }
}
