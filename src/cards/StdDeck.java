package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StdDeck implements Deck {
    public List<Card> cards;
    private final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final String[] SUITS = {"♤", "♥", "♧", "♦"};

    public StdDeck() {
        cards = new ArrayList<>();

        for(var suit : SUITS) {
            for(var value : VALUES) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() - 1);
    }
}
