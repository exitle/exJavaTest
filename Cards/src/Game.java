
public class Game {

	public static void main(String[] args) {
		Deck deck1 = new Deck();
		deck1.shuffle();
		
		War war = new War(deck1);
		war.dealCards();
		war.playWar();

	}

}
