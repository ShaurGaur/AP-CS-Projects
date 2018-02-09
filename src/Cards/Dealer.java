package Cards;

public class Dealer extends Player {
    private static final int HIT_THRESHOLD = 17;
    private static final int ACE_THRESHOLD = 10;

    public Dealer() {
        super("Computer");
    }

    @Override
    public boolean choosesHit() {return super.getScore() < HIT_THRESHOLD;}

    @Override
    public int acePoints() {
        if (super.getScore() <= ACE_THRESHOLD) return 11;
        else return 1;
    }
}
