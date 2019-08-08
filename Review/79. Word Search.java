class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = rows == 0 ? 0 : board[0].length;
        int[] dir = new int[] { 0, 1, 0, -1, 0 };
        char[] words = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, words, rows, cols, 0, i, j, dir)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int rows, int cols, int index, int i, int j, int[] dir) {
        if (index == words.length) {
            return true;
        }

        if (i == rows || j == cols || i < 0 || j < 0) {
            return false;
        }

        if (words[index] != board[i][j]) {
            return false;
        }

        boolean exist = false;
        board[i][j] += 26;
        for (int k = 0; k < 4; k++) {
            exist = exist || dfs(board, words, rows, cols, index + 1, i + dir[k], j + dir[k + 1], dir);
        }
        board[i][j] -= 26;

        return exist;
    }
}