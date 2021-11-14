package chap7;

public class Minesweeper {

    /**
     * I think we can have an array of numbers, then have some random position for the mines
     * then add them, then add the surrounding numbers. For playing, whenever we choose to
     * uncover a cell, first we need to see if that is already uncovered. If it is not,
     * we can uncover it and show it. If not, we can show a dot .
     * whenever we uncover a blank cell, we can uncover everything surrounding that blank cell,
     * if it is just a number, then just show it.
     * Sunday 14/11/2021 I'm gonna start with the board
     */

    int[][] board;
    boolean[][] uncoveredPieces;
    int size;

    public Minesweeper(int size){
        board = new int[size][size];
        uncoveredPieces = new boolean[size][size];
        this.size=size;
    }
    public Minesweeper(){
        int size = 8;
        this.size=size;
        board = new int[size][size];
        uncoveredPieces = new boolean[size][size];
    }

    public void printBoard(){
        /**
         * . = not shown
         * 1 = 1 mine around
         * 2 = 2 mines around
         * * = mine
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
