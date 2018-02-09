package Cards;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;    private List<Card> hand;    private int score;    private int staycount;
    static Scanner input = new Scanner(System.in);

    public Player(String name) {this.name = name; this.hand = new ArrayList<>(); score = 0;}
    public Player() {this.hand = new ArrayList<>(); this.name = "Player";}

    public List<Card> getHand() {return hand;}    public void setHand(List<Card> hand) {this.hand = hand;}
    public String getName() {return name;}    public void addStay() {staycount++;}
    public void setStayCount(int stays) {staycount = stays;}    public int getStayCount() {return staycount;}
    public void setScore(int score) {this.score = score;}    public int getScore() {return score;}
    public void addToScore(int pts) {score += pts;}    public void addCard(Card card) throws Exception {hand.add(card);}

    public void playTurn(CardDeck deck) {
        if (choosesHit()) {playCard(deck); setStayCount(0);} else addStay();
        showHand(); setScoreAfterPlay();
    }

    public boolean choosesHit() {
        String hit = "";
        while (!(hit.equals("h") || hit.equals("s"))) {
            System.out.print("\nPress h to hit or s to stay: ");
            hit = input.nextLine().toLowerCase();
        }
        return hit.equals("h");
    }

    public void setScoreAfterPlay() {
        setScore(0);
        for (Card card : hand) {
            String value = card.getValue();
            if (value.equals("A")) {addToScore(acePoints());}
            else if (value == "J" || value == "K" || value == "Q") {addToScore(10);}
            else {addToScore(Integer.parseInt(value));}
        }
        System.out.printf("%n%s's Score: %s%n", name, score);
    }

    public void showHand() {
        if (hand.size() > 0) {
            System.out.print("\n" + name + "'s hand: ");
            for (Card card : getHand()) {System.out.print("\n    " + card);}
            System.out.print("\n");
        }
    }

    public void playCard(CardDeck deck) {
        Card card = deck.dealTopCard(); System.out.println("\n" + name + " HITS! " + card + ".");
        try {addCard(card);} catch(Exception e) {e.printStackTrace();}
    }

    public int acePoints() {
        String ace; int acePoints = 0;
        do {
            System.out.print("\nYou have an Ace! Press x for 1 or y for 11: ");
            ace = input.nextLine().toLowerCase();
        } while(!(ace.equals("x")|| ace.equals("y")));

        if (ace.equals("x")) {acePoints = 1;}
        else if (ace.equals("y")) {acePoints = 11;}
        return acePoints;
    }
}

