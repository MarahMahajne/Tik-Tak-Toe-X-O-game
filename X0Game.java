// [ Marah Mahajne][marahmahajne68@gmail.com]

import java.util.Scanner;

public class X0Game {

    public static void manger(int N) {
        boolean player1 = true;
        boolean player2 = false;
        boolean tie = false;
        int rounds = 1, emptySpaces = N * N;
        char[][] board = createBoard(N);
        printBoard(board);
        while (!finish(board)) {
            if (emptySpaces == 0)
            {
                tie = true;
                break;
            }
            else if (rounds % 2 == 0) {
                player2 = true;
                player1 = false;
                System.out.print("Player 2 (O) it's your turn, Enter a position: ");
            } else {
                player1 = true;
                player2 = false;
                System.out.print("Player 1 (X) it's your turn, Enter a position: ");
            }
            play(board, player1,  player2);
            printBoard(board);
            emptySpaces --;
            rounds++;
        }
        if (tie) {
            System.out.print("It's a tie!");
        } else if (player1) {
            System.out.print("Congratulations player 1,  You Won!");
        } else {
            System.out.print("Congratulations player 2,  You Won!");
        }
    }


    public static char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '*';
            }
        }
        return board;
    }


    public static void play(char[][] board, boolean player1, boolean player2) {
        boolean flag = false;
        int x = -1, y = -1, count = 0;
        String input;
        String[] arr;
        Scanner sc = new Scanner(System.in);
        while (!flag) {
            try {
                count = 0;
                input = sc.next();
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == ',') {
                        count++;
                    }
                }
                arr = input.split(",");
                if (arr.length == 2 && count == 1) {
                    x = Integer.parseInt(arr[0]);
                    y = Integer.parseInt(arr[1]);
                    flag = true;
                    if ( x > board.length || y > board.length || x < 0 || y < 0) {
                        System.out.print("The position you entered is out of range, Enter another position: ");
                        flag = false;
                    }
                } else {
                    System.out.print("Invalid Input!, enter a valid position (x, y):");
                    flag = false;
                }
            } catch (Exception e) {
                flag = false;
                System.out.print("invalid position! enter the number of the raw, column: ");
            }
        }
        x--;
        y--;
        // Taken position
        while (board[x][y] != '*') {
            System.out.print("This placement is taken, choose another one!: ");
            input = sc.next();
            arr = input.split(",");
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            x--;
            y--;
        }
        if (player1)
            board[x][y] = 'X';
        if (player2)
            board[x][y] = 'O';
    }

    public static boolean finish(char[][] board) {
        int cRow = 0, cColumn = 0, cDiagonal = 0, cLeftDiagonal = 0;
        int n = board.length;
        char savedR = '*', savedL = '*';
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 'X' || board[i][j] == 'O') {

                      //ROW
                      if (j + 1 < board.length) {
                        if (board[i][j] == board[i][j + 1]) {
                            cRow++;
                        }
                      }

                    //Column
                    if (j + 1 < board.length) {
                        if (board[j][i] == board[j + 1][i]) {
                            cColumn++;
                        }
                    }

                    //Right Diagonal
                    if (j == i) {
                        if (savedR == '*') {
                            savedR = board[i][j];
                        } else if (savedR == board[i][j]) {
                            cDiagonal++;
                        }
                    }

                    //left Diagonal
                    if (i + j == board.length - 1) {
                        if (savedL == '*') {
                            savedL = board[i][j];
                        } else if (savedL == board[i][j]) {
                            cLeftDiagonal++;
                        }
                    }

                }
            }
            if (cRow == n - 1 || cColumn == n - 1) {
                return true;
            }
            cRow = 0;
            cColumn = 0;
        }
        if (cLeftDiagonal == n - 1 || cDiagonal == n - 1)
            return true;

        return false;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        System.out.print("Please enter the size of the board: ");
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int N = 0;
        while(!flag) {
            try {
                 N = sc.nextInt();
                 flag = true;
                 if (N < 3) {
                     flag = false;
                     System.out.print("Invalid input!, Enter a number bigger or equal to 3: ");
                 }
            } catch (Exception e) {
                flag = false;
                System.out.print("Invalid input!, Enter a number bigger or equal to 3: ");
                sc.next();
            }
        }
        System.out.print("Game is on !\n");
        manger(N);
    }
}
