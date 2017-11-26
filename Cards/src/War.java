
import java.util.ArrayList;
import java.util.List;

public class War {

    private List<Card> player1;
    private List<Card> player2;
    private List<Card> stack;
    private Deck deck;

    War(Deck deck) {
        this.deck = deck;
        this.player1 = new ArrayList<Card>();
        this.player2 = new ArrayList<Card>();
        this.stack = new ArrayList<Card>();
    }

    public List<Card> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<Card> player1) {
        this.player1 = player1;
    }

    public List<Card> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<Card> player2) {
        this.player2 = player2;
    }

    void dealCards() {
        for (int i = 0; i < deck.getDeckSize(); i++) {
            if (i % 2 == 0) {
                this.player1.add(deck.getCard(i));
            } else {
                this.player2.add(deck.getCard(i));
            }
        }
    }

    public void printHands() {
        printPlayer(player1, "Player 1");
        printPlayer(player2, "Player 2");
    }

    private void printPlayer(List<Card> p, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name+": |");
        for (Card aP : p) {
            sb.append(aP.getCard() + "|");
        }
        System.out.println(sb.toString());
    }

    private void turnDisplay(Card p1, Card p2) {
        System.out.printf("Player1: %s | Player2: %s%n"
                , p1.getCard()
                , p2.getCard());

        if (p1.getValue() > p2.getValue()) {
            System.out.println("Player1 wins the round!");
        } else if (p2.getValue() > p1.getValue()) {
            System.out.println("Player2 wins the round!");
        } else {
            System.out.println("Draw.");
        }
    }

    int playWar() {
        int counter = 0;
        while (player1.size() > 0 && player2.size() > 0) {
            Card p1 = player1.get(0);
            Card p2 = player2.get(0);
            int p1v = p1.getValue();
            int p2v = p2.getValue();

            System.out.println("\nRound #" + counter + "\t(" + player1.size() + " | " + player2.size() + ")");
            turnDisplay(p1, p2);

            player1.remove(0);
            player2.remove(0);

            if (p1v > p2v) {
                player1.add(p1);
                player1.add(p2);
                if (stack.size() > 0) {
                    while (stack.size() > 0) {
                        player1.add(stack.get(0));
                        stack.remove(0);
                    }
                }
            } else if (p2v > p1v) {
                player2.add(p1);
                player2.add(p2);
                if (stack.size() > 0) {
                    while (stack.size() > 0) {
                        player2.add(stack.get(0));
                        stack.remove(0);
                    }
                }
            } else {
                stack.add(p1);
                stack.add(p2);
            }

			if ( counter==10000 ) break;

            counter++;
        }
        return counter;
    }

}
