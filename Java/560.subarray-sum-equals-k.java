/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (41.67%)
 * Total Accepted:    86.8K
 * Total Submissions: 207.7K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 * 
 */
class Solution {
    private int subarraySum3(int[] nums, int k) {
        int[] memo = new int[nums.length + 1];
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            memo[i] = memo[i - 1] + nums[i - 1];
        }
        // notice j condition should be j <= nums.length
        // since the last element may be part of the subarray
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (memo[j] - memo[i] == k) {
                    ++count;
                }
            }
        }
        return count;
    }

    private int subarraySum1(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    private int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int count = 0, curSum = 0;
        m.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (m.containsKey(curSum - k)) {
                count += m.get(curSum - k);
            }
            m.put(curSum, m.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        return subarraySum2(nums, k);
    }
}

