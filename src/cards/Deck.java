package cards;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        List<String> validValues = Card.getValidValues();
        List<String> validSuits = Card.getValidSuits();

        cards = new ArrayList<>();

        for(var suit : validSuits) {
            for(var value : validValues) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        String output = "";

        for(var card : cards) {
            output += (card + "\n");
        }

        return output;
    }
}
