import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        ArrayList<Integer> res = new ArrayList<>(rows * cols);
        
        int times = 0;
        while (rows > times * 2 && cols > times * 2) {
            int endX = cols - times - 1;
            int endY = rows - times - 1;
            
            // up
            for (int i = times;i <= endX; i++) {
                res.add(matrix[times][i]);
            }
            
            // right
            if (times < endY) {
                for (int i = times + 1; i <= endY; i++) {
                    res.add(matrix[i][endX]);
                }
            }

            // bottom
            if (times < endX && times < endY) {
                for (int i = endX - 1; i >= times; i--) {
                    res.add(matrix[endY][i]);
                }
            }

            // right
            if (times < endX && times < endY - 1) {
                for (int i = endY - 1; i >= times + 1; i--) {
                    res.add(matrix[i][times]);
                }
            }

            ++times;
        }
        return res;
    }
}