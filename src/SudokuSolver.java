public class SudokuSolver {

    private static final int SIZE = 9;

    public static boolean solveSudoku(int[][] board) {
        return solveRecursive(board, 0, 0);
    }

    /* Este metodo recursivo se encarga de resolver el sudoku */
    private static boolean solveRecursive(int[][] board, int row, int col) {
        if (row == SIZE) {
            return true;
        }
        if (col == SIZE) {
            return solveRecursive(board, row + 1, 0);
        }
        if (board[row][col] != 0) {
            return solveRecursive(board, row, col + 1);
        }
        for (int num = 1; num <= SIZE; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveRecursive(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    /* Esto se encarga de ver si se puede poner el numero en las celdas vacias teniendo en cuenta las reglas del sudoku */
    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /*Esto se encarga de imprimir el tablero sin resolver y el resuelto */
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 5, 0, 1, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Tablero sin resolver:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("Tablero resuelto:");
            printBoard(board);
        } else {
            System.out.println("No existe una solución.");
        }
    }

    /* Este imprime el tablero en la consola */
    private static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] == 0 ? ". " : board[r][d] + " ");
            }
            System.out.println();
        }
    }
}
