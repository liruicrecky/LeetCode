class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                ++l;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                --r;
            }

            if (l < r && s.charAt(l) != s.charAt(r)) {
                return false;
            }

            ++l;
            --r;
        }

        return true;
    }
}