package ui;

import java.util.Scanner;

public class Console implements UI {

    private Scanner scanner = new Scanner(System.in);


    @Override
    public String getString(String q) {
        if(!q.isEmpty()) {
            System.out.println(q);
            return scanner.next();
        } else {
            throw new IllegalArgumentException("ERROR: EMPTY QUERY");
        }
    }

    @Override
    public int getInt(String q) {
        if(!q.isEmpty()) {
            System.out.println(q);
            return scanner.nextInt();
        } else {
            throw new IllegalArgumentException("ERROR: EMPTY QUERY");
        }
    }

    @Override
    public void cls() {
        int i = 100;
        while (i > 0) {
            System.out.println("\n");
            i--;
        }
    }
}
