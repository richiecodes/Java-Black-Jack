package cards;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceValue, suit;

    public Card(String faceValue, String suit) {
        setFaceValue(faceValue);
        setSuit(suit);
    }

    public static List<String> getValidValues() {
        return Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");

    }

    private void setFaceValue(String faceValue) {
        if(getValidValues().contains(faceValue)) {
            this.faceValue = faceValue;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid Value: " + faceValue);
        }
    }

    public String getFaceValue() {
        return faceValue;
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("Clubs", "Spades", "Hearts", "Diamonds");
    }

    private void setSuit(String suit) {
        if(getValidSuits().contains(suit)) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid Suit: " + suit);
        }
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String output = "";

        output += String.format("%s of %s", faceValue, suit);

        return output;
    }
}
