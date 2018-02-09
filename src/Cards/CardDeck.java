package Cards;

import java.util.*;

public class CardDeck {
    private Deque<Card> deck = new ArrayDeque<>(52);
    public static String[] suits = {"SPADES", "HEARTS", "CLUBS", "DIAMONDS"};
    public static String[] faces = {"J", "K", "Q", "A"};

    //test code
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        deck.dealTopCard();
    }

    public CardDeck() {
        for (String suit : suits) {
            for (int j = 2; j <= 10; j++) {deck.add(new Card(j + "", suit));}
            for (String face : faces) {deck.add(new Card(face, suit));}
        }
    }

    public Deque<Card> getDeck() {return deck;}
    public int getSize() {return deck.size();}
    public void addCard(String value, String suit) {
        //Check for duplicates or if deck is full?
        deck.add(new Card(value, suit));
    }
    public Card dealTopCard() {return deck.removeFirst();}
    public void removeCard(String value, String suit) {
        Card rCard = new Card(value, suit);
        for (Card dCard : deck) {if (rCard.equals(dCard)) {deck.remove(dCard);}}
    }

    public void shuffle() {
        Random rand = new Random();
        List<Card> list = cardList();
        boolean[] isRemoved = new boolean[list.size()];
        Deque<Card> newDeck = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            int r; do {r = rand.nextInt(list.size());} while(isRemoved[r]);
            newDeck.add(list.get(r));
            isRemoved[r] = true;
        }

        deck = newDeck;
    }

    public List<Card> cardList() {
        List<Card> list = new ArrayList<>();
        for (Card card : deck) {list.add(card);}
        return list;
    }
}

