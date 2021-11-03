package chap7;

public class Book {
    int numberOfPages;
    String name;
    String[] authors;
    int howManyTimesRead;
    String category;

    public Book(String name, String[] authors){
        this.name=name;
        this.authors=authors;
    }
}
