import java.util.Scanner;

class TicTacToe {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        // Loop for play again prompt
        while (playAgain) {
            char board[][] = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            char currentPlayer = 'X';
            boolean gameOnGoing = true;

            // Loop for game
            while (gameOnGoing) {
                printBoard(board);
                System.out.print("Player " + currentPlayer + " Enter your position (1-9): ");
                char position = sc.next().charAt(0);

                if (position >= '1' && position <= '9') {
                    if (placeMove(board, position, currentPlayer)) {
                        if (checkWin(board, currentPlayer)) {
                            printBoard(board);
                            System.out.println("Player " + currentPlayer + " wins!");
                            gameOnGoing = false;
                        } else if (isBoardFull(board)) {
                            printBoard(board);
                            System.out.println("It's a draw!!!");
                            gameOnGoing = false;
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    } else {
                        System.out.println("Position is already taken! Try again later.");
                    }
                } else {
                    System.out.println("Invalid position! Try again.");
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
    }

    // Method to print the current state of the board
    public static void printBoard(char board[][]) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(" ------- ");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(" ------- ");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    // Method to place a move on the board
    public static boolean placeMove(char[][] board, char position, char symbol) {
        int row = (position - '1') / 3;
        int col = (position - '1') % 3;

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println("Position is already taken!");
            return false;
        }
    }

    // Method to check if the current player has won
    public static boolean checkWin(char[][] board, char currentPlayer) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) ||
                    (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    // Method to check if the board is full
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
