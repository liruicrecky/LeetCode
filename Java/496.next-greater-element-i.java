/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (58.79%)
 * Total Accepted:    90.8K
 * Total Submissions: 153.5K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2. 
 * 
 * 
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * ⁠   For number 4 in the first array, you cannot find the next greater number
 * for it in the second array, so output -1.
 * ⁠   For number 1 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 2 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * ⁠   For number 2 in the first array, the next greater number for it in the
 * second array is 3.
 * ⁠   For number 4 in the first array, there is no next greater number for it
 * in the second array, so output -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 * 
 */
class Solution {
    private int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Deque<Integer> que = new ArrayDeque<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums2) {
            while (!que.isEmpty() && que.peekLast() < num) {
                m.put(que.pollLast(), num);
            }
            que.add(num);
        }
       
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = m.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    private int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Map<Integer, Integer> m = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            m.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int j = m.get(nums1[i]) + 1;
            for (;j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreaterElement2(nums1, nums2);
    }
}

