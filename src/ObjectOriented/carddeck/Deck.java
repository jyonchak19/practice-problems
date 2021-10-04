package ObjectOriented.carddeck;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private int topIndex = 0; // marks the top of the deck

    public Deck(){

    }

    public void shuffle(){

    }

//    public Card[] dealHand(int num) {
//        if(num > remainingCards())
//            return null;
//        Card[] hand = new Card[num];
//        // for(int i = 0; )
//
//    }

    public int remainingCards() {
        return cards.size() - topIndex;
    }

    public Card dealCard() {
        if(remainingCards() == 0)
            return null;
        Card card = cards.get(topIndex);
        topIndex++;
        card.markUnavailable();
        return card;
    }
}

