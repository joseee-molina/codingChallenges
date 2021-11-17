package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest extends Minesweeper {
    @Test

    public void initialTest(){
        Minesweeper m = new Minesweeper(4,2,5);
        m.prepareGame();
        //nice! Tomorrow i will add the uncovering

        m.uncoverPiece(3,2);
        m.uncoverPiece(0,0);
        m.uncoverPiece(1,0);
        m.uncoverPiece(2,0);
        m.uncoverPiece(0,1);
        m.uncoverPiece(1,1);
        m.uncoverPiece(0,2);
        m.uncoverPiece(0,3);
        m.uncoverPiece(1,2);
        m.uncoverPiece(1,3);
        m.uncoverPiece(2,2);
        m.uncoverPiece(3,3);

        m.printBoard();
        //It was fun!
    }

}