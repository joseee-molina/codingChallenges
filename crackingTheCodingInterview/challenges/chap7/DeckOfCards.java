package chap7;

public class DeckOfCards <T> {
    /**
     * Problem 1: Design a generic deck of cards
     */
    Card[] deck;

    public DeckOfCards(Card[] deck){
        this.deck = deck;
    }
}
/**
 * We can create blackjack by extending the DeckOfCards class and also
 * even creating the blackjack cards extending the Card class.
 */
