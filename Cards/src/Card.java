
public class Card {

	private String card;
	private int value;

	public Card(String card, int value) {
		this.card = card;
		this.value = value;
	}
	
	public String getCard() {
		return card;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setCard(String card) {
		this.card = card;
	}
		
}
