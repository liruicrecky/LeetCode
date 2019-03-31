/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (52.78%)
 * Total Accepted:    141.8K
 * Total Submissions: 268K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 
 */
class Solution {
    private List<Integer> findDisappearedNumbers1(int[] nums) {
        if (nums.length == 0) { return Collections.emptyList(); }

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private List<Integer> findDisappearedNumbers2(int[] nums) {
        if (nums.length == 0) { return Collections.emptyList(); }

        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0;i < len; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0;i < len; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        return findDisappearedNumbers2(nums);
    }
}

