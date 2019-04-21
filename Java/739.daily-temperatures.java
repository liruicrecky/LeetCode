/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (59.18%)
 * Total Accepted:    58.8K
 * Total Submissions: 98.3K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * 
 */
class Solution {

    private int[] dailyTemperatures3(int[] T) {
        int[] ans = new int[T.length];

        for (int i = T.length - 2; i >= 0; --i) {
            if (T[i] < T[i + 1]) {
                ans[i] = 1;
            } else {
                int j = i + 1;
                while (ans[j] != 0) {
                    j += ans[j];
                    if (T[j] > T[i]) {
                        ans[i] = j - i;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    private int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);

        for (int i = T.length - 1; i >= 0; i--) {
            int index = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (next[j] < index) {
                    index = next[j];
                }
            }
            if (index < Integer.MAX_VALUE) {
                ans[i] = index - i;
            }
            next[T[i]] = i;
        }

        return ans;
    }

    private int[] dailyTemperatures1(int[] T) {
        int len = T.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    public int[] dailyTemperatures(int[] T) {
        return dailyTemperatures3(T);
    }
}

