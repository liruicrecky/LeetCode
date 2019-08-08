class Solution {
    public String minWindow(String s, String t) {
        int[] memo = new int[128];
        for (char c : t.toCharArray()) {
            memo[c]++;
        }

        int count = t.length(), str = 0, end = 0, minS = 0, minE = 0, minLen = Integer.MAX_VALUE;
        int size = s.length();

        while (end < size) {
            if (memo[s.charAt(end)] > 0) {
                --count;
            }

            --memo[s.charAt(end)];
            ++end;

            while (count == 0) {
                if (end - str < minLen) {
                    minLen = end - str;
                    minS = str;
                    minE = end;
                }

                ++memo[s.charAt(str)];
                if (memo[s.charAt(str)] > 0) {
                    ++count;
                }
                ++str;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minS, minE);
    }
}