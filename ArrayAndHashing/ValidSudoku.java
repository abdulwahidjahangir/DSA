package ArrayAndHashing;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, char curr, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == curr) {
                return false;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (i != col && board[row][i] == curr) {
                return false;
            }
        }

        int stRow = (row / 3) * 3;
        int stCol = (col / 3) * 3;

        for (int i = stRow; i < stRow + 3; i++) {
            for (int j = stCol; j < stCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == curr) {
                    return false;
                }
            }
        }

        return true;
    }
}
