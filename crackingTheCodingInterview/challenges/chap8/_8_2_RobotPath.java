package chap8;

public class _8_2_RobotPath {
    /*
    There is a robot in the top left of a board with r rows and c columns,
    it can move down and right, and it wants to arrive the bottom right cell.
    there are however, some cells that he cannot step in, so we need to find
    a path so that it can arrive its destination.

    ------------------------------------------------------------------------
    a program that comes to my mind is:

    {
        if(arrivedToDestination){
            print it and finish the game
        }
        if(cangoright){
            goright() //this until we find we cannot, we go down, if not possible, we dont go
        }
        if(cangodown){

        }
    }
        but since it is late today, i will implement it tomorrow
     */

    public void findPathToEnd(int[][] board){
        //0 for no problem, 1 for cannot pass
        pathHelper(board, 0,0);

    }



    public void pathHelper(int[][] board, int i, int j){
        int cols = board[0].length;
        int rows = board.length;
        if(i==rows-1 && j == cols-1){
            System.out.println("Congrats, arrived!!!");
            return;
        }
        if(i+1<rows && board[i+1][j]!=1){
            pathHelper(board,i+1,j);
        }
        if(j+1<cols && board[i][j+1]!=1){
            pathHelper(board, i, j+1);
        }
    }

    public void print2DArr(int[][] arr){
        for(int i = 0 ; i<arr.length;i++){
            for(int j = 0 ; j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
