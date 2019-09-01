class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] live = new int[rows][cols];
        int[] neighbors = new int[] { 0, 1, -1 };
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count = 0;
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (neighbors[ii] == 0 && neighbors[jj] == 0) {
                            continue;
                        }

                        int ir = i + neighbors[ii];
                        int jc = j + neighbors[jj];
                        if (ir >= 0 && ir < rows && jc >= 0 && jc < cols && board[ir][jc] == 1) {
                            ++count;
                        }
                    }
                }
                live[i][j] = count;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    if (live[i][j] < 2 || live[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (live[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}