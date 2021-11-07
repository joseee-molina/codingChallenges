package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OthelloTest extends Othello {
    @Test
    public void othelloTest1(){
        Othello g = new OthelloTest();
        g.printBoard();
    }

}