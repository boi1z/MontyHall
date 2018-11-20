package montyhall;

import java.util.Arrays;

public class MontyHall {
    public static void main(String[] args) {
        String[] choices;
        int switchSum = 0;
        int staySum = 0;
        for (int i = 0; i < 1000; i++) {
            choices = new String[3];
            Arrays.fill(choices, "goat");
            choices[(int)(Math.random()*3)] = "car";
            int choice = (int)(Math.random()*3);
            int[] goats = new int[2];
            int ctr = 0;
            for (int n = 0; n < 3; n++)
                if (choices[n].equals("goat")) {
                    goats[ctr] = n;
                    ctr++;
                }
            int pick = goats[(int)(Math.random()*2)];
            if (pick == choice) {
                if (pick == goats[0])
                    pick = goats[1];
                else
                    pick = goats[0];
            }
            int swit = -1;
            for (int n = 0; n < 3; n++) 
                if (n!=choice && n!=pick)
                    swit = n;
            int win = -1;
            for (int n = 0; n < 3; n++)
                if (choices[n].equals("car"))
                    win = n;
            String winner = "";
            if (choices[swit].equals("car")) {
                switchSum++;
                winner = "Switch";
            }
            if (choices[choice].equals("car")) {
                staySum++;
                winner = "Stay";
            }
            System.out.println("Winning choice: " + win);
            System.out.println("Initial choice: " + choice);
            System.out.println("Revealed goat:  " + pick);
            System.out.println("Switched choice:" + swit);
            System.out.println(winner + " wins\n");
        }
        System.out.println("Switch: " + switchSum);
        System.out.println("Stay:   " + staySum);
    }
}