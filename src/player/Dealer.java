package player;

import cards.Card;
import cards.StdDeck;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Hand {
    private StdDeck deck;
    private List<Card> dealerHand;

    public Dealer() {
        deck = new StdDeck();
        deck.shuffle();
        dealerHand = new ArrayList<>();
    }

    public void dealHandToPlayer(Player player) {
        List<Card> playerHand = new ArrayList<>();
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        player.addCardsToHand(playerHand);
    }

    public void dealCardToPlayer(Player player) {
        player.addCardToHand(deck.draw());
    }

    public List<Card> dealHandToSelf() {
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());

        dealerHand.get(1).setHidden(true);

        return dealerHand;
    }

    public void showHand() {
        System.out.println("Dealer Hand: " + dealerHand.toString().trim());
    }

    public List<Card> getHand() {
        return dealerHand;
    }

    public void addCardsToHand() {
        dealerHand.add(deck.draw());
    }

    public void validateHand() {
        int sum = dealerHand.get(0).getValue() + dealerHand.get(dealerHand.size() - 1).getValue();

        while(sum <= 21) {
            if(sum < 17) {
                addCardsToHand();
                showHand();
                sum += dealerHand.get(dealerHand.size() - 1).getValue();
                for(var card : dealerHand) {
                    if(card.getValue() == 1 && sum < 11) {
                        card.setValue(11);
                    }
                }
            } else {
                break;
            }
        }

        if(sum > 21) {
            System.out.println("DEALER BUST");
        } else if(sum == 21) {
            System.out.println("DEALER BLACK JACK");
        }else {
            System.out.println("Dealer Stood with value: " + sum);
        }
    }

    public StdDeck getDeck() {
        return deck;
    }
}