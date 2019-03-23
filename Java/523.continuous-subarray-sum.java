/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (24.14%)
 * Total Accepted:    60.4K
 * Total Submissions: 250.2K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * Given a list of non-negative numbers and a target integer k, write a
 * function to check if the array has a continuous subarray of size at least 2
 * that sums up to the multiple of k, that is, sums up to n*k where n is also
 * an integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up
 * to 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5
 * and sums up to 42.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit
 * integer.
 * 
 * 
 */
class Solution {
    private boolean checkSubarraySum1(int[] nums, int k) {
        boolean res = false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (j == i) { continue; }
                if (k == 0 && sum == 0 || 
                    k != 0 && sum % k == 0) {
                    res = true;
                    break;
                }
            }
            if (res) { break; }
        }
        return res;
    }

    // use (a - b) % k = (a % k - b % k) % k
    private boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            curSum = k == 0 ? curSum : curSum % k;
            Integer t = m.get(curSum);
            if (t != null) {
                if (i - t > 1) {
                    return true;
                }
            } else {
                m.put(curSum, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        return checkSubarraySum2(nums, k);
    }
}

