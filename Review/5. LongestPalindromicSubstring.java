class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();
        int mL = 0, mR = 0;
        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            while (right < len && s.charAt(right) == s.charAt(i)) {
                ++right;
            }
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                --left;
            }
            
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            
            ++left;
            if (right - left > mR - mL) {
                mL = left;
                mR = right;
            }
        }
        
        return s.substring(mL, mR);
    }
}