package chap7;

public class Othello {
    /**
     * The japanese chess is black and white double sided circular pieces,
     * with a 8x8 board where you place white or black pieces. So I prefer to
     * include an array of 0, 1, 2 array of the board, where 0 = unoccupied,
     * 1 = white piece, 2 = black piece in that position of the board
     *
     * Initializing we have 2 black and 2 white pieces in the board.
     *
     * Whenever we place a pair of blacks on the both sides of an uninterrupted
     * series of whites, then we can flip the whites in between. The same happens
     * for whites and blacks. The series can happen in horizonta, vertical and diagonals.
     *
     *
     *
     */
    int[][] board;

    public Othello(){
        board = new int[8][8];
        board[3][3] = 1;
        board[4][4] = 1;
        board[3][4] = 2;
        board[4][3] = 2;
    }

    public void printBoard(){
        for(int i  = 0 ; i<8; i++){
            for(int j = 0 ; j<8;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
