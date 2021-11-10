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
        /*g.putAPiece(3,6,true);
        g.printBoard();
        g.putAPiece(3,2,true);
        g.printBoard();
        */
        g.putAPiece(5,3,true);
        g.printBoard();
        g.putAPiece(2,3,true);
        g.printBoard();
        g.putAPiece(2,4,true);
        g.printBoard();
        g.putAPiece(5,4,true);
        g.printBoard();
        //these tests show that it is working for horizontal and vertical
        g.putAPiece(3,2,false);
        g.printBoard();
        //worked horizontally
        g.putAPiece(1,2,false);
        g.printBoard();
        
    }


}