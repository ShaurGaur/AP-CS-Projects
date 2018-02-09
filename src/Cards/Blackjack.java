//TERMINAL COMMANDS (Codenvy)
//Navigate:    cd /projects/Blackjack
//Rebuild:     javac -classpath /projects/Blackjack: -sourcepath src: -d /projects/Blackjack/bin src/Blackjack.java
//Run:         java -classpath /projects/Blackjack/bin Blackjack
package Cards;
import java.util.Scanner;

public class Blackjack {
    static Scanner input = new Scanner(System.in);
    static CardDeck deck = new CardDeck();

    public static void main(String[] args) {
        deck.shuffle();
        Dealer comp = new Dealer();

        System.out.println("BLACKJACK");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        Player user = new Player(name);
        Player[] players = {user, comp};

        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                try {player.addCard(deck.dealTopCard());}
                catch(Exception e) {e.printStackTrace();}
            }
            player.showHand();
            player.setScoreAfterPlay();
        }

        //play turns for each player, eliminate once score is over 21
        //game ends when one player has busted or hit 21 or when one player has stayed for 3 turns in a row
        while (user.getScore() < 21 && comp.getScore() < 21 && user.getStayCount() < 3 && comp.getStayCount() < 3) {
            for (Player player : players) {player.playTurn(deck);}
        }

        if (user.getScore() == comp.getScore()) System.out.println("Draw!");
        else if (user.getScore() > 21 && comp.getScore() <= 21) winMessage(comp);
        else if (comp.getScore() > 21 && user.getScore() <= 21) winMessage(user);
        else if (user.getScore() < 21 && comp.getScore() < 21) {
            if (user.getScore() > comp.getScore()) winMessage(user);
            else if (comp.getScore() > user.getScore()) winMessage(comp);
        }
        else if (user.getScore() > 21 && comp.getScore() > 21) {
            if (user.getScore() < comp.getScore()) winMessage(user);
            else if (comp.getScore() < user.getScore()) winMessage(comp);
        }
    }

    public static void winMessage(Player player) {
        System.out.println("\n" + player.getName() + " wins!");
        if (player.getScore() == 21) System.out.println(player.getName() + " got 21!!!");
    }
}
