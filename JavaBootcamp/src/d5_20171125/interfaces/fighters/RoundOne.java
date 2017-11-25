package d5_20171125.interfaces.fighters;


import d5_20171125.interfaces.fighters.abstracts.Boxer;
import d5_20171125.interfaces.fighters.abstracts.Fighter;
import d5_20171125.interfaces.fighters.abstracts.Karate;

import java.util.Scanner;

/**
 * Created: 25.11.17.
 */
public class RoundOne {
    public static void main(String[] args) {

        Fighter redFighter = new Boxer("Andrew");
        Fighter blueFighter = new Karate("Miyagi");
        Fighter winner;

        Scanner sc = new Scanner(System.in);
        System.out.println(redFighter.getName());
        System.out.println(blueFighter.getName());

        while (true) {
            interpretUserInput(redFighter, blueFighter, sc);

            printFightersStats(redFighter, blueFighter);

            if (redFighter.getEnergy() <= 0) {
                winner = blueFighter;
                break;
            } else if (blueFighter.getEnergy() <= 0) {
                winner = redFighter;
                break;
            }
        }

        printWinner(winner);

    }

    private static void interpretUserInput(Fighter redFighter, Fighter blueFighter, Scanner sc) {
        String userInput = sc.next();
        if (userInput.equals("r")) {
            redFighter.punch(blueFighter);
        } else if (userInput.equals("b")) {
            blueFighter.punch(redFighter);
        } else {
            System.out.println("");
        }
    }

    private static void printWinner(Fighter winner) {
        System.out.printf("Winner: %s", winner.getName());
    }

    private static void printFightersStats(Fighter redFighter, Fighter blueFighter) {
        System.out.printf("Red fighter: %s%nBlue fighter: %s%n%n",
                blueFighter.getEnergy(),
                redFighter.getEnergy());
    }
}
