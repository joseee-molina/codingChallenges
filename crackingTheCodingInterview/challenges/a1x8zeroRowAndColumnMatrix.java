import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class a1x8zeroRowAndColumnMatrix {

    public static int[][] makeZeroRowAndColumn(int[][] matrix){
        printMatrix(matrix);
        LinkedList<Point> fringe = new LinkedList<>();
        fillPointFringeWithZeroCoordinates(matrix,fringe);
        while(!fringe.isEmpty()){
            Point p = fringe.poll();
            individualRowAndColumnZero(matrix,p);
        }
        printMatrix(matrix);
        return matrix;
    }

    public static void fillPointFringeWithZeroCoordinates(int[][] matrix, LinkedList<Point> list){
        for(int i = 0 ; i<matrix.length;i++){
            for(int j = 0 ; j<matrix[i].length;j++){
                int x = matrix[i][j];
                if(x==0){
                    Point p = new Point(i,j);
                    list.add(p);
                }
            }
        }
    }

    public static void individualRowAndColumnZero(int[][] matrix, Point pos){
        for(int i = 0; i<matrix[0].length; i++){
            matrix[pos.x][i] = 0;
        }
        for(int i = 0 ; i<matrix.length;i++){
            matrix[i][pos.y] = 0;
        }
    }

    public static void printMatrix(int[][] matrix){
        System.out.println();
        for(int row = 0 ; row<matrix.length ; row++){
            for(int column = 0 ; column<matrix[row].length ; column++){
                System.out.print(matrix[row][column] + "  ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixWithConsecutiveIntegers(int[][] matrix){
        int n = 1;
        for(int row = 0 ; row<matrix.length ; row++){
            for(int column = 0 ; column<matrix[row].length ; column++){
                matrix[row][column] = n;
                n++;
            }
        }
    }
}
