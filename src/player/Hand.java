package player;

import cards.Card;

import java.util.List;

public interface Hand {
    void showHand();
    List<Card> getHand();
}
