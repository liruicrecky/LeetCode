class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        backTrace(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void backTrace(List<String> res, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max << 1) {
            res.add(sb.toString());
        } else {
            if (open < max) {
                backTrace(res, sb.append("("), open + 1, close, max);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                backTrace(res, sb.append(")"), open, close + 1, max);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}