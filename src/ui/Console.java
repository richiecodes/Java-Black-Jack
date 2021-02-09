package ui;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

    public int getNumber(String query, int min, int max) {
        int inputInt = 0;

        do {
            System.out.println(query);
            String input = scanner.nextLine();
            try {
                inputInt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid input!");
            }

        } while(inputInt < min || inputInt > max);

        return inputInt;
    }

    public String getString(String query) {
        System.out.println(query);
        return scanner.nextLine();
    }

    public void cls() {
        int i = 100;
        while(i > 0) {
            System.out.println("\n");
            i--;
        }
    }
}
