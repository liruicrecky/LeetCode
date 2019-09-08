class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        if (board.length < 3 || board[0].length < 3) {
            return;
        }

        int rows = board.length, cols = board[0].length;
        int[] dir = new int[] { 0, 1, 0, -1, 0 };

        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, rows, cols, 0, i, dir);
            }

            if (board[rows - 1][i] == 'O') {
                dfs(board, rows, cols, rows - 1, i, dir);
            }
        }

        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, rows, cols, i, 0, dir);
            }

            if (board[i][cols - 1] == 'O') {
                dfs(board, rows, cols, i, cols - 1, dir);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int rows, int cols, int i, int j, int[] dir) {
        if (i < 0 || j < 0 || i == rows || j == cols) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'A';
        for (int k = 0; k < 4; k++) {
            dfs(board, rows, cols, i + dir[k], j + dir[k + 1], dir);
        }
    }
}