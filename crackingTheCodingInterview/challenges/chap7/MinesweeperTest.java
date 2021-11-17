package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest extends Minesweeper {
    @Test

    public void initialTest(){
        Minesweeper m = new Minesweeper(8,6,2);
        m.prepareGame();
        m.uncoverPiece(5,0);
        //nice! Tomorrow i will add the uncovering
        


        m.printBoard();
    }

}