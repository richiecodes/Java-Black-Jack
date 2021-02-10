package player;

import cards.Card;
import ui.Console;

import java.util.ArrayList;
import java.util.List;

public class Player implements Hand {
    private List<Card> hand;
    private String name;
    private int chips;
    Console console = new Console();

    private int playerBet;

    public Player() {
        this.name = setName();
        this.chips = setChips();
        hand = new ArrayList<>();
    }

    public int setChips() {
        return console.getNumber("Enter amount of starting chips (100-500)", 100, 500);
    }

    public String setName() {
        String playerName = console.getString("Enter Player Name");
        return (playerName.substring(0, 1).toUpperCase() + playerName.substring(1));
    }

    public void showHand() {
        System.out.println(name + "'s Hand: " + hand.toString().trim());
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardsToHand(List<Card> cards) {
        for(var card : cards) {
            hand.add(card);
        }
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card getCard() {
        return hand.get(hand.size() - 1);
    }

    public String getName() {
        return name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public boolean validateHand() {
        int sum = 0;

        for(var card : hand) {
            sum += card.getValue();
        }

        if(sum <= 21) {
            return true;
        }
        else {
            System.out.println(name + " busted!");
            setChips(getChips() - (playerBet * 2));
        }

        return true;
    }

    public void setPlayerBet(int bet) {
        this.playerBet = bet;
        setChips(getChips() - bet);
    }

    public int getPlayerBet() {
        return playerBet;
    }
}
