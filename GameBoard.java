public class GameBoard{
private final int BOARD_SIZE = 3;
private char board[][] = new char[BOARD_SIZE][BOARD_SIZE];

    public GameBoard(){
        for (int r = 0; r < BOARD_SIZE; r++){
            for (int c = 0; c < BOARD_SIZE; c++){
                board[r][c] = '-';
            }
        }
    }

    public char[][] insert(char c, int row, int col){
        board[row][col] = c;
        return board;
    }

    public void printBoard(){
        for (int r = 0; r < BOARD_SIZE; r++){
            for(int c = 0; c < BOARD_SIZE; c++){
                System.out.print(board[r][c]);
            }
            System.out.print("\n");
        }
    }

    public boolean checkWin(char c, int row, int col){
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++){ // check vertical
            if (board[i][col] == c){
                count++;
            }
        }    
        if (count == BOARD_SIZE){
            return true;
        }

        count = 0;
        for (int i = 0; i < BOARD_SIZE; i++){ // check horizontal
            if (board[row][i] == c){
                count++;
            }
        }
        if (count == BOARD_SIZE){
            return true;
        }

        count = 0;
        if (row == col){ // check diagonal (slope going down)
            for (int i = 0, j = 0; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++){
                if (board[i][j] == c){
                    count++;
                }
            }
        }
        if (count == BOARD_SIZE){
            return true;
        }

        count = 0;
        if (col == BOARD_SIZE-row-1){ // check diagonal (slope going up)
            for (int i = 0, j = BOARD_SIZE-1; i < BOARD_SIZE && j >= 0; i++, j--){
                if (board[i][j] == c){
                    count++;
                }
            }
        }
        if (count == BOARD_SIZE){
            return true;
        }

        return false;
    }
}