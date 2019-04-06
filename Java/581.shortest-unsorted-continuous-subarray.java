/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.65%)
 * Total Accepted:    61.7K
 * Total Submissions: 206.9K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.  
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * 
 * Note:
 * 
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means . 
 * 
 * 
 */
class Solution {
    private int findUnsortedSubarray4(int[] nums) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                minVal = Math.min(minVal, nums[i]);
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                maxVal = Math.max(maxVal, nums[i]);
            }
        }

        int l = 0, r = nums.length - 1;
        for (; l < nums.length; l++) {
            if (nums[l] > minVal) {
                break;
            }
        }
        for (; r >= 0; r--) {
            if (nums[r] < maxVal) {
                break;
            }
        }

        return r > l ? r - l + 1 : 0;
    }

    private int findUnsortedSubarray3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - l >= 0 ? r - l + 1 : 0; 
    }

    private int findUnsortedSubarray2(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tmp[i]) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }

        return r - l >= 0 ? r - l + 1 : 0;
    }

    private int findUnsortedSubarray1(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }

        return r - l >= 0 ? r - l + 1 : 0;
    }

    public int findUnsortedSubarray(int[] nums) {
        return findUnsortedSubarray4(nums);
    }
}

