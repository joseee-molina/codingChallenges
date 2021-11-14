package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest extends Minesweeper {
    @Test

    public void initialTest(){
        Minesweeper m = new Minesweeper();
        m.printBoard();
    }

}