/**
Написать программу, показывающую последовательность действий для игры “Ханойская башня”
 */
public class HW11 {
    /** Function shows an array
    * @param board an array
    * @param row amount of rows
    * @param cols amount of columns
    */  
    public static void showBoard(int[][] board, int row, int cols) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    System.out.print("|"); 
                    System.out.print("\t");
                }
                else{
                    System.out.print(board[i][j]); 
                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    /** Function returns a row number
    * @param board an array
    * @param row amount of rows
    * @param nCol number of column where we are going to find a disk
    */  
    public static int getRow(int[][] board, int row, int nCol) {
        int nRow = -1;
        for (int i = 0; i < row; i++) {
            if (board[i][nCol] != 0) {
                nRow = i;
                break;
            }
        }
        return nRow;
    }
     /** Function moves only one disk
    * @param board an array
    * @param row amount of rows
    * @param cols amount of columns
    * @param point1 
    * @param point2 
    */  
    public static void move(char point1, char point2, int[][] board, int row, int cols) {
        int col1 = (int)point1 - (int)'A';
        int col2 = (int)point2 - (int)'A';
        int row1 = getRow(board, row, col1);
        int row2 = getRow(board, row, col2);
        if (row2 == -1) {
            row2 = row - 1;
        }
        else{
            row2--;
        }
        int value = board[row1][col1];
        board[row1][col1] = 0;
        board[row2][col2] = value;
        showBoard(board, row, cols);
    }
     /** Function checks is array empty or not
    * @param board an array
    * @param row amount of rows
    * @param cols amount of columns
    */  
    public static boolean isEmpty(int[][] board, int row, int cols) {
        int lastRowIndex = row - 1;
        for (int j = 0; j < cols; j++) {
            if (board[lastRowIndex][j] != 0) {
                return false;
            }
        }
        return true;
    }
     /** Function fills an array with values
    * @param diskCount a disk count
    * @param board an array
    * @param row amount of rows
    * @param cols amount of columns
    */  
    public static int[][] initBoard(int diskCount, int[][] board, int row, int nCol) {
        int lastRowIndex = row - 1;
        for (int i = lastRowIndex; diskCount > 0 ; i--) {
            board[i][nCol] = diskCount;
            diskCount--;
        }
        return board;
    }
    /** Function moves the whole tower
    * @param amount amount of disks
    * @param point1 a column number
    * @param point2 a column number
    * @param temp a supportive column
    * @param board an array
    * @param row amount of rows
    * @param cols amount of columns
    */  
    public static void moveTower(int amount, char point1, char point2, char temp, int[][] board, int row, int cols) {
        if (amount == 0) {
            return;
        }
        if (isEmpty(board, row, cols)) {
            initBoard(amount, board, row, 0);
            System.out.println("Initial position\n");
            showBoard(board, row, cols);
        }
        moveTower(amount - 1, point1, temp, point2, board, row, cols);
        move(point1, point2, board, row, cols);
        moveTower(amount - 1, temp, point2, point1, board, row, cols);
    }
    /** Function fills an array with zero numbers
    * @param row amount of rows
    * @param cols amount of columns
    */  
    public static int[][] fillArray(int rows, int cols) {
        int[][] board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static void main(String[] args) {
        int rows = 5;
        int cols = 3;
        int[][] board = fillArray(rows, cols);
        moveTower(3, 'A', 'B', 'C', board, rows, cols);
    }
}