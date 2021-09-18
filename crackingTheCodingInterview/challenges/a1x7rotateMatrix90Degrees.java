public class a1x7rotateMatrix90Degrees {
    public static int[][] rotate90Degrees(int[][] matrix){
        printMatrix(matrix);
        transposeMatrix(matrix);
        reflectOnX(matrix);
        printMatrix(matrix);
        return matrix;
    }

    public static void transposeMatrix(int[][] matrix){
        //rows become columns, or x,y becomes y,x
        for(int row = 0 ; row<matrix.length ; row++){
            for(int column = row ; column<matrix[row].length ; column++){
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
    }

    public static void reflectOnX(int[][] matrix){
        for(int row = 0 ; row<matrix.length ; row++){
            for(int column = 0 ; column<matrix[row].length/2 ; column++){
                int temp = matrix[row][matrix.length-1-column];
                matrix[row][matrix.length-1-column] = matrix[row][column];
                matrix[row][column] = temp;
            }
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
