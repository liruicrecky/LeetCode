import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }

        int s = 1, e = 2;
        int limit = (sum + 1) >> 1;
        int sumArr = s + e;
        while (s < limit) {
            if (sumArr == sum) {
                ArrayList<Integer> t = new ArrayList<>();
                for (int i = s; i <= e; i++) {
                    t.add(i);
                }
                res.add(t);
                sumArr -= s;
                ++s;
            } else if (sumArr > sum) {
                sumArr -= s;
                ++s;
            } else {
                ++e;
                sumArr += e;
            }
        }

        return res;
    }
}