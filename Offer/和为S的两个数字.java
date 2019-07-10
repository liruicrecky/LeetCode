import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int s = 0, e = array.length - 1;
        while (s < e) {
            int sumTwo = array[s] + array[e];
            if (sumTwo == sum) {
                ArrayList<Integer> t = new ArrayList<>(2);
                t.add(array[s]);
                t.add(array[e]);
                m.put(s * e, t);
                ++s;
            } else if (sumTwo > sum) {
                --e;
            } else {
                ++s;
            }
        }

        return m.size() == 0 ? new ArrayList<Integer>() : m.firstEntry().getValue();
    }
}