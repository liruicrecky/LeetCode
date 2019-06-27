import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        
        int s = 0, e = array.length - 1;
        int res = array[0];
        while (array[s] >= array[e]) {
            if (e - s == 1) {
                res = array[e];
                break;
            }
            int mid = (s + e) >> 1;
            if (array[s] <= array[mid]) {
                s = mid;
            } else {
                e = mid;
            }
        }
        
        return array[e];
    }
}