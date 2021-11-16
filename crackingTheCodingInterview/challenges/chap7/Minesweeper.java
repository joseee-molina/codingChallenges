package chap7;
import java.util.ArrayList;
import java.util.Random;

public class Minesweeper {

    /**
     * I think we can have an array of numbers, then have some random position for the mines
     * then add them, then add the surrounding numbers. For playing, whenever we choose to
     * uncover a cell, first we need to see if that is already uncovered. If it is not,
     * we can uncover it and show it. If not, we can show a dot .
     * -1 = mine
     * whenever we uncover a blank cell, we can uncover everything surrounding that blank cell,
     * if it is just a number, then just show it.
     * We can uncover blank cells using the BFS, storing the indexes to visit in some set,
     * and running a while loop on them
     *
     * 1. Put the mines - done
     * 2. Put surrounding numbers - done
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

    public void prepareGame(){
        putMines();
        putNumsAroundMines();
    }

    public void uncoverBlankArea(int i, int j){
        ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
        ArrayList<Integer> singleCoord = new ArrayList<>();
        if(i+1<size){
            singleCoord.add(i+1);
            singleCoord.add(j);
            coords.add(singleCoord);
        }
        if(i-1>=0){
            singleCoord= new ArrayList<>();
            singleCoord.add(i-1);
            singleCoord.add(j);
            coords.add(singleCoord);
        }
        if(j+1<size){
            singleCoord=new ArrayList<>();
            singleCoord.add(i);
            singleCoord.add(j+1);
            coords.add(singleCoord);

        }
        if(j-1>=0){
            singleCoord=new ArrayList<>();
            singleCoord.add(i);
            singleCoord.add(j-1);
            coords.add(singleCoord);

        }
    }


    public void uncoverPiece(int i, int j){
        if(uncoveredPieces[i][j]==true){
            System.out.println("This piece is already uncovered! Choose another one");
            return;
        }
        uncoveredPieces[i][j] = true;
        if(board[i][j] == 0){
            //uncover all surrounding white area up left right and down

        }
    }

    public void putNumsAroundMines(){

        for(int i = 0 ; i<size;i++){
            for (int j = 0 ; j<size;j++){
                int num = 0 ;
                if(i+1<size && board[i+1][j]==-1) num++;
                if(i+1<size && j+1<size && board[i+1][j+1]==-1) num++;
                if(j+1<size && board[i][j+1]==-1) num++;
                if(i-1>=0 && board[i-1][j]==-1) num++;
                if(j-1>=0 && board[i][j-1]==-1) num++;
                if(i-1>=0 && j-1>=0 && board[i-1][j-1]==-1) num++;
                if(i+1<size && j-1>=0 && board[i+1][j-1]==-1) num++;
                if(i-1>=0 && j+1<size && board[i-1][j+1]==-1) num++;
                if(board[i][j]!=-1){
                    board[i][j] = num;

                }
            }
        }
    }

    public void putMines(){
        Random rand = new Random(1);
        for(int i = 0 ; i<=numberOfMines;i++){

            int randnum = rand.nextInt(size*size);
            int counter = 0 ;

            for(int j = 0 ; j<size;j++){
                for(int k = 0; k<size;k++){
                    if(counter==randnum){
                        board[j][k]=-1;
                        break;
                    }
                    counter++;
                }
                if(counter==randnum){
                    break;
                }
            }
        }
    }

    public void printBoard(){
        /**
         * . = not shown
         * 1 = 1 mine around
         * 2 = 2 mines around
         * * = mine = -1 in the board[][]
         */

        for(int i = 0 ;i<size;i++){
            for(int j = 0 ; j<size;j++){
                ///**

                if(uncoveredPieces[i][j]==false){
                    System.out.print('.' + " ");
                    continue;
                }
                 //**/
                //-1 for mine there
                if(board[i][j]==-1){
                    System.out.print("*" + " ");
                    continue;
                }
                if(board[i][j]==0){
                    System.out.print("0 ");
                    //Correct one!!
                    // System.out.print(" "+ " ");

                }
                if(board[i][j]!=0){
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
