/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */
class Solution {
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int num : nums) {
            if (m.get(num) == 1) {
                res = num;
                break;
            }
        }

        return res;
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = -1;
        for (int num : nums) {
            ones = ones ^ num & twos;
            twos = twos ^ num & ones;
        }
        return ones;
    }
}

