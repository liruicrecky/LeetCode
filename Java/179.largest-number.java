/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {

    private class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String o1 = a + b;
            String o2 = b + a;
            return o2.compareTo(o1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, new CustomComparator());

        if (s[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String ss : s) {
            sb.append(ss);
        }

        return sb.toString();
    }
}

