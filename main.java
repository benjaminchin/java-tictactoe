import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe!\n");

        boolean gameOver = false;
        char currentPlayer = 'X';
         
        while(gameOver == false) {
            display(board);
            char winner = checkWinner(board);
            if(winner != 'n') {
                gameOver = true;
                System.out.println("The winner is: " + winner);
                break;
            }

            System.out.println("Choose row:");
            int row = input.nextInt();
            System.out.println("Choose col:");
            int col = input.nextInt();

            board[row][col] = currentPlayer;
            currentPlayer = changePlayer(currentPlayer);
         }
         input.close();
    }

    public static void display(char[][] board) {
        System.out.println("  0   1   2");
        
        for(int i = 0; i < 3; i++) { 
            System.out.println(i + " " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            if(i < 2) {
                System.out.println(" -----------"); 
            }
            
        }
    }

    public static char checkWinner(char[][] board) {
        /* Check diagonals */
        if((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != ' ') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != ' ')) {
            return(board[1][1]);
        }

        /* Check rows and columns */
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                return(board[i][0]);
            } 
            else if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ') {
                return(board[0][i]);
            }
        }
        return 'n';
    }

    public static char changePlayer(char currentPlayer) {
        if(currentPlayer == 'X') {
            return('O');
        } else {
            return('X');
        }
    }
}
