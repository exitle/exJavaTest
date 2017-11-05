
public class Card {

    private String card;
    private int value;

    Card(String card, int value) {
        this.card = card;
        this.value = value;
    }

    String getCard() {
        return card;
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCard(String card) {
        this.card = card;
    }

}
