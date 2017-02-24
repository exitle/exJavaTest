import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck {
	
    private String[] cards = {"2","3","4","5","6","7","8","9","10","W","J","K","A"};
    private String[] suits = {"\u2665"/*♥*/,"\u2666"/*♦*/,"\u2663"/*♣*/,"\u2660"/*♠*/};
    private int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	private List<Card> deck;
    
    public String[] getCards() {
		return cards;
	}
    
	public String[] getSuits() {
		return suits;
	}
	
	public int[] getValues() {
		return values;
	}
	
	public List<Card> initDeck(){
        this.deck = new ArrayList<Card>();
        for(int i=0; i<this.cards.length;i++){
            for (String suit : suits) {
            	Card c = new Card(suit + this.cards[i], this.values[i]);
            	this.deck.add(c);
            }
        }
		return deck;
	}
	
	public List<Card> shuffle(){
		this.initDeck();
		List<Card> tempDeck = new ArrayList<Card>();
		Iterator<Card> it = deck.iterator();
		
		while(it.hasNext()){
			int rnd = (int) Math.floor(Math.random()*(deck.size()-1)+1);
			try {
				tempDeck.add(this.deck.get(rnd));
				this.deck.remove(rnd);
			} catch (Exception e) {
				tempDeck.add(this.deck.get(0));
				this.deck.remove(0);
			}
		}
		this.deck = tempDeck;
		return deck;
	}
    
	public String printDeck(){
		String strDeck = "";
		for (int i=0;i<deck.size();i++){
			strDeck += deck.get(i).getCard() + ((i>=deck.size()-1) ? "" : ", ");
		}
		return strDeck;
	}
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	public Card getCard(int i) {
		return deck.get(i);
	}
	
	public String getCardName(Card c){
		return c.getCard();
	}
	
	public int getCardValue(Card c){
		return c.getValue();
	}

}
