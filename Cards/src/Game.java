
public class Game {

    public static void main(String[] args) {
        Deck deck1 = new Deck();
        deck1.shuffle();
//        System.out.println(deck1);

        War war = new War(deck1);
        war.dealCards();
//		war.printHands();
        int rounds = war.playWar();
        System.out.println(rounds);
    }

}
