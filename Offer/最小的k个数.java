import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0) {
            return res;
        }
        
        int s = 0, e = input.length - 1;
        int pri = parti(input, s, e);
        while (pri != k - 1) {
            if (pri > k - 1) {
                pri = parti(input, s, pri - 1);
            } else {
                pri = parti(input, pri + 1, e);
            }
        }
        
        for (int i = 0; i <= pri; i++) {
            res.add(input[i]);
        }
        return res;
    }
    
    private int parti(int[] arr, int s, int e) {
        int t = arr[s];
        while (s < e) {
            while (s < e && arr[e] >= t) {
                --e;
            }
            if (s < e) {
                arr[s] = arr[e];
            }
            
            while (s < e && arr[s] <= t) {
                ++s;
            }
            if (s < e) {
                arr[e] = arr[s];
            }
        }
        arr[s] = t;
        return s;
    }
}