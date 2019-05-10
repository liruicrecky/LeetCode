/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums1) {
            s.add(num);
        }

        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (s.contains(num)) {
                res.add(num);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}

