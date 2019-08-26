class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            count += extractPalindromic(s, len, i, i);
            count += extractPalindromic(s, len, i, i + 1);
        }
        
        return count;
    }
    
    private int extractPalindromic(String s,int len, int left, int right) {
        int count = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            ++count;
        }
        
        return count;
    }
}