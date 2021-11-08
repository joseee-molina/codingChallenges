package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OthelloTest extends Othello {
    @Test
    public void othelloTest1(){
        Othello g = new OthelloTest();
        g.printBoard();
        g.putAPiece(3,5,false);
        g.printBoard();
        g.putAPiece(4,2,false);
        g.printBoard();
        g.putAPiece(3,6,true);
        g.printBoard();
        g.putAPiece(3,2,true);
        g.printBoard();
    }

}