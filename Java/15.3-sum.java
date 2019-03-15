import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.50%)
 * Total Accepted:    496.3K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = 0 - nums[i];
                for (int j = i + 1, k = nums.length - 1; j < k;) {
                    if (nums[j] + nums[k] == l) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < k && nums[j] == nums[j + 1]) { ++j; }
                        while(j < k && nums[k] == nums[k - 1]) { --k; }
                        --k;
                        ++j;
                    } else if (nums[j] + nums[k] > l) {
                        --k;
                    } else {
                        ++j;
                    }
                }
            }
        }
        return res;
    }
}

