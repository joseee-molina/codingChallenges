package chap7;

public class Card <T> {
    /**
     * Cards have an item and a number, but they may have more
     * data such as in the case of monopoly, so we can maybe
     * include an array of data for the card, or even a HashMap
     */
    T item;
    int num;
    public Card (T item, int num){
        this.item=item;
        this.num=num;
    }
}
