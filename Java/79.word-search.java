/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.46%)
 * Total Accepted:    267.9K
 * Total Submissions: 868.4K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {

    private boolean dfs(char[][] board, char[] word, int row, int col, int index, int i, int j) {
        if (index == word.length) {
            return true;
        }

        if (i < 0 || j < 0 || i == row || j == col) {
            return false;
        }
        
        if (board[i][j] != word[index]) {
            return false;
        }

        board[i][j] += 26;
        boolean exist = dfs(board, word, row, col, index + 1, i + 1, j)
            || dfs(board, word, row, col, index + 1, i - 1, j)
            || dfs(board, word, row, col, index + 1, i, j + 1)
            || dfs(board, word, row, col, index + 1, i, j - 1);
        board[i][j] -= 26;

        return exist ;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        char[] words = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, words, row, col, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

