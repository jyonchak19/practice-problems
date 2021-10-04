package ObjectOriented.carddeck;

public class Card {
    private boolean available = true;
    // values between 1-13, 1,11,12,13 -> Ace, Jack, Queen, King
    protected int faceValue;
    protected Suit suit;

    public boolean isAvailable(){
        return available;
    }

    public void markAvailable(){
        available = true;
    }

    public void markUnavailable(){
        available = false;
    }

    public void print() {
        // print the card "A of Clubs", "9 of Hearts"
    }
}
