import java.lang.Math;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        int next = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        
        while (next < index) {
            int min = Math.min(Math.min(res[i2] * 2, res[i3] * 3), res[i5] * 5);
            res[next] = min;
            while (res[i2] * 2 <= res[next]) {
                ++i2;
            }
            while (res[i3] * 3 <= res[next]) {
                ++i3;
            }
            while (res[i5] * 5 <= res[next]) {
                ++i5;
            }
            ++next;
        }
        return res[next - 1];
    }
}