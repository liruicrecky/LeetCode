import java.util.ArrayList;

public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = A[i + 1] * right[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}