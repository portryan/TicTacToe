import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What size board?: ");
        int size = input.nextInt();
        GameBoard b = new GameBoard(size);
        b.printBoard();
        
        int turn = 0;
        char player;
        while (true){
            if (turn % 2 == 0){
                player = 'X';
            }else{
                player = 'O';
            }
            System.out.println("\n" + player + "'s turn!");
            System.out.println("Which row?: ");
            int row = input.nextInt();
            System.out.println("Which column?: ");
            int col = input.nextInt();

            b.insert(player, row, col);
            b.printBoard();

            if(b.checkWin(player, row, col)){
                System.out.println(player + " WINS!");
                break;
            }
            turn++;
        }
        input.close();
    }

}