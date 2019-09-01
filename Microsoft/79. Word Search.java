class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word == null) {
            return false;
        }

        int rows = board.length, cols = board[0].length;
        char[] words = word.toCharArray();
        int[] dir = new int[] { 0, 1, 0, -1, 0 };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, words, rows, cols, i, j, 0, dir)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int rows, int cols, int i, int j, int index, int[] dir) {
        if (index == words.length) {
            return true;
        }

        if (i < 0 || j < 0 || i == rows || j == cols) {
            return false;
        }

        if (board[i][j] != words[index]) {
            return false;
        }

        boolean res = false;
        board[i][j] += 26;
        for (int k = 0; k < 4; k++) {
            res = res || dfs(board, words, rows, cols, i + dir[k], j + dir[k + 1], index + 1, dir);
        }
        board[i][j] -= 26;

        return res;
    }
}