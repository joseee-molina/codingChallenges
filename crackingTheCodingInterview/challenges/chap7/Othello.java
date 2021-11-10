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
        System.out.println();

    }

    public void putAPiece(int i, int j, boolean isBlack){
        if(board[i][j]!=0){
            System.out.println("occupied place, choose another one");
            return;
        }

        int piece = isBlack ? 2 : 1;

        board[i][j] = piece;
        //TODO: check adjacencies on the horizontal, vertical and diagonal
        int wantedPiece = isBlack ? 2 : 1;
        int wantedIndex = j;
        // checking to the right of the board
        for(int k = j+1; k<8;k++) {
            if (board[i][k] == wantedPiece) {
                wantedIndex = k;
                break;
            }
        }
        flipPieces(i,j,j+1,wantedIndex,true,false);
        // checking to the left of the board
        wantedIndex=j;
        for(int k = j-1; k>=0;k--) {
            if (board[i][k] == wantedPiece) {
                wantedIndex = k;
                break;
            }
        }
        flipPieces(i,j,wantedIndex+1,j,true,false);
        // checking to the lower level
        wantedIndex = i;
        for(int k = i+1; k<8;k++){
            if(board[k][j]==wantedPiece){
                wantedIndex=k;
                break;
            }
        }
        flipPieces(i,j,i+1,wantedIndex,false,false );
        // checking to thw upper level
        wantedIndex = i;
        for(int k = i-1; k>=0;k--){
            if(board[k][j]==wantedPiece){
                wantedIndex=k;
                break;
            }
        }
        flipPieces(i,j,wantedIndex+1,i,false,false );

        //checking low right
        wantedIndex=i;
        for(int k=1;k+i<8 && k+j<8; k++){
            if(board[i+k][j+k]==wantedPiece){
                wantedIndex=k;
                break;
            }
        }
        flipPieces(i,j,i,wantedIndex, false,true);

        //checking up left
        wantedIndex=-2;
        for(int k=1;i-k>=0 && j-k>=0; k++){
            if(board[i-k][j-k]==wantedPiece){
                wantedIndex=k;
                break;
            }
        }
        flipPieces(i-wantedIndex,j-wantedIndex,0,wantedIndex, false,true);

    }

    public void flipPieces(int column, int row, int i, int j, boolean horizontal, boolean diagonal){
        if(horizontal){
            if(Math.abs(i-j)<1){
                //adjacent pieces, nothing to flip here
                return;
            }
            for(int k = i ;k<j;k++){
                int curr = board[column][k];
                if(curr==1){
                    board[column][k]=2;
                }
                else{
                    board[column][k]=1;
                }
            }
        }
        if(diagonal){
            if(Math.abs(i-j)<1){
                //adjacent pieces, nothing to flip here
                return;
            }
            for(int k = 1 ; k<j;k++){
                int curr = board[column+k][row+k];
                if(curr==1){
                    board[column+k][row+k]=2;
                }
                else{
                    board[column+k][row+k]=1;
                }
            }
        }
        if(!horizontal && !diagonal){
            if(Math.abs(i-j)<1){
                return;
            }
            for(int k = i; k<j;k++){
                int curr = board[k][row];
                if(curr==1){
                    board[k][row]=2;
                }
                else{
                    board[k][row]=1;
                }
            }
        }

    }
}
