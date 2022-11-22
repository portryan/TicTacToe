import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameBoard b = new GameBoard();

        while (true){
            System.out.println("Enter Letter (X or O): ");
            char letter = input.next().charAt(0);
            System.out.println("Which row?: ");
            int row = input.nextInt();
            System.out.println("Which column?: ");
            int col = input.nextInt();

            b.insert(letter, row, col);
            b.printBoard();

            if(b.checkWin(letter, row, col)){
                System.out.println(letter + " WINS!");
                break;
            }
        }
    }

}