/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> t = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    t.add(1);
                } else if (j == i) {
                    t.add(1);
                } else {
                    t.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(t);
        }
        return res;
    }
}

