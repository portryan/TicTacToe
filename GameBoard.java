public class GameBoard{
    private char board[][];
    private int boardSize;
    
    public GameBoard(){
        boardSize = 3;
        initBoard(boardSize);
    }

    public GameBoard(int size){
        boardSize = size;
        initBoard(boardSize);
    }

    public void initBoard(int size){
        board = new char[size][size];
        for (int r = 0; r < boardSize; r++){
            for (int c = 0; c < boardSize; c++){
                board[r][c] = '-';
            }
        }
    }

    public boolean insert(char c, int row, int col){
        if (board[row][col] == '-'){
            board[row][col] = c;
            return true;
        }else{
            return false;
        }
    }

    public void printBoard(){
        for (int r = 0; r < boardSize; r++){
            for(int c = 0; c < boardSize; c++){
                System.out.print(board[r][c]);
            }
            System.out.print("\n");
        }
    }

    public boolean checkWin(char c, int row, int col){
        int count = 0;
        for (int i = 0; i < boardSize; i++){ // check vertical
            if (board[i][col] == c){
                count++;
            }
        }    
        if (count == boardSize){
            return true;
        }

        count = 0;
        for (int i = 0; i < boardSize; i++){ // check horizontal
            if (board[row][i] == c){
                count++;
            }
        }
        if (count == boardSize){
            return true;
        }

        count = 0;
        if (row == col){ // check diagonal (slope going down)
            for (int i = 0, j = 0; i < boardSize && j < boardSize; i++, j++){
                if (board[i][j] == c){
                    count++;
                }
            }
        }
        if (count == boardSize){
            return true;
        }

        count = 0;
        if (col == boardSize-row-1){ // check diagonal (slope going up)
            for (int i = 0, j = boardSize-1; i < boardSize && j >= 0; i++, j--){
                if (board[i][j] == c){
                    count++;
                }
            }
        }
        if (count == boardSize){
            return true;
        }

        return false;
    }
}