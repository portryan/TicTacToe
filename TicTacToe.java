import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What size board?: ");
        int size = input.nextInt();
        GameBoard b = new GameBoard(size);
        b.printBoard();
        
        char player;
        for (int turn = 0; turn < (size * size); turn++){
            if (turn % 2 == 0){
                player = 'X';
            }else{
                player = 'O';
            }
            int row, col;
            while (true){
                System.out.println("\n" + player + "'s turn!");
                System.out.println("Which row?: ");
                row = input.nextInt();
                System.out.println("Which column?: ");
                col = input.nextInt();

                if (b.insert(player, row, col)){
                    break;
                }else{
                    System.out.println("ERROR: Choose another position");
                }
            }
            
            b.printBoard();

            if(b.checkWin(player, row, col)){
                System.out.println(player + " WINS!");
                System.exit(0);
            }
        }
        System.out.println("TIE!");
        input.close();
    }

}