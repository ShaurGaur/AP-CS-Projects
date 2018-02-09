package Cards;

public class Card {
    private String value;
    private String suit;

    public Card(String val, String st) {
        value = val;
        suit = st;
    }

    public String getValue() {return value;}
    public void setValue(String value) {this.value = value;}
    public String getSuit() {return suit;}
    public void setSuit(String suit) {this.suit = suit;}

    public String toString() {return value + " of " + suit;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (value != null ? !value.equals(card.value) : card.value != null) return false;
        return suit != null ? suit.equals(card.suit) : card.suit == null;

    }
}

