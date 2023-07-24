import java.util.Scanner;

public class ticTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();
        display();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int rowMove = 0;
            int colMove = 0;
            while (true) { //Player movement logic
                System.out.println("Player " + currentPlayer + ", Choose row (1-3): ");
                rowMove = scanner.nextInt();
                System.out.println("Player " + currentPlayer + ", Choose column (1-3): ");
                colMove = scanner.nextInt();

                if (isValidMove(rowMove, colMove)) {
                    break;
                } else {
                    System.out.println("Invalid selection, try again.");
                }
            }

            // Player choice to correct array index (choice - 1)
            int row = rowMove - 1;
            int col = colMove - 1;

            board[row][col] = currentPlayer;

            display();

            // Win-Tie checker
            if (isWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }

            // Player
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
        }

        scanner.close();
    }
    //board wipe
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }
    //display wipe
    private static void display() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("---------");
            }
        }
    }
    //move validity check
    private static boolean isValidMove(int row, int col) {
        if (row < 1 || row > ROW || col < 1 || col > COL) {
            return false;
        }
        int rowIdx = row - 1;
        int colIdx = col - 1;
        return board[rowIdx][colIdx].equals(" ");
    }
    //win checkier
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    //win by a row
    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    //win by a col
    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
    //win by diag
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    //no win, tie
    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // Empty cell present, no tie
                }
            }
        }
        return true; // No empty cells, tie
    }
}