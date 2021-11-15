package chap7;
import java.util.Random;

public class Minesweeper {

    /**
     * I think we can have an array of numbers, then have some random position for the mines
     * then add them, then add the surrounding numbers. For playing, whenever we choose to
     * uncover a cell, first we need to see if that is already uncovered. If it is not,
     * we can uncover it and show it. If not, we can show a dot .
     * 3 = mine
     * whenever we uncover a blank cell, we can uncover everything surrounding that blank cell,
     * if it is just a number, then just show it.
     * We can uncover blank cells using the BFS, storing the indexes to visit in some set,
     * and running a while loop on them
     *
     * 1. Put the mines
     * 2. Put surrounding numbers
     *
     * 3. Uncover pieces mechanism
     *
     * Sunday 14/11/2021 I'm gonna start with the board
     *
     *
     */

    int[][] board;
    boolean[][] uncoveredPieces;
    int size;
    int numberOfMines;

    public Minesweeper(int size, int numberOfMines){
        board = new int[size][size];
        uncoveredPieces = new boolean[size][size];
        this.size=size;
        this.numberOfMines=numberOfMines;
    }
    public Minesweeper(){
        int size = 8;
        this.size=size;
        board = new int[size][size];
        uncoveredPieces = new boolean[size][size];
        this.numberOfMines=3;
    }

    public void putMines(){
        for(int i = 0 ; i<numberOfMines;i++){
            Random rand = new Random();
            int randnum = rand.nextInt(size*size);
            int counter = 0 ;
            for(int j = 0 ; j<size;j++){
                for(int k = 0; k<size;k++){
                    if(counter==randnum){
                        board[j][k]=3;
                        break;
                    }
                    counter++;
                }
            }
        }
    }

    public void printBoard(){
        /**
         * . = not shown
         * 1 = 1 mine around
         * 2 = 2 mines around
         * * = mine = 3 in the board[][]
         */

        for(int i = 0 ;i<size;i++){
            for(int j = 0 ; j<size;j++){
                if(uncoveredPieces[i][j]==false){
                    System.out.print('.' + " ");
                    continue;
                }
                //3 for mine there
                if(board[i][j]==3){
                    System.out.print("*" + " ");
                }
                if(board[i][j]==0){
                    System.out.print(" "+ " ");
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}