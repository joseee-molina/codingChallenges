package chap7;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class OnlineBookReader {

    HashMap<Book, Integer> books; //how many times read


    public OnlineBookReader(HashMap<Book, Integer>  books){
        this.books=books;
    }

    public void readBook(OnlineBookReaderUser user, Book book){
        user.booksReadNumber++;
        if(!books.containsKey(book)){
            throw new NoSuchElementException();
        }
        book.howManyTimesRead++;
    }

}
