class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        List<List<String>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backTrace(List<List<String>> res, List<String> tmp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tmp.add(s.substring(start, i + 1));
                    backTrace(res, tmp, s, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}