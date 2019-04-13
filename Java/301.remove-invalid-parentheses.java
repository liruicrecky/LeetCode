/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (38.49%)
 * Total Accepted:    116.6K
 * Total Submissions: 300.1K
 * Testcase Example:  '"()())()"'
 *
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Example 1:
 * 
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ")("
 * Output: [""]
 * 
 */
class Solution {

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                --count;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    private List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) { return res; }

        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        que.offer(s);
        visited.add(s);

        while (!que.isEmpty()) {
            int len = que.size();
            for (int k = 0; k < len; k++) {
                String tmp = que.poll();
                if (isValid(tmp)) {
                    res.add(tmp);
                } else {
                    for (int i = 0; i < tmp.length(); i++) {
                        if (Character.isLetter(tmp.charAt(i))) {
                            continue;
                        }
                        String sub = tmp.substring(0, i) + tmp.substring(i + 1);
                        if (!visited.contains(sub)) {
                            visited.add(sub);
                            que.offer(sub);
                        }
                    }
                }
            }
            if (res.size() > 0) { break; }
        }

        if (res.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {sb.append(c); }
            }
            res.add(sb.toString());
        }
        return res;
    }

    private void backTrace(String s, StringBuilder sb, int count, int start, int leftRe, int rightRe, Set<String> set) {
        if (start == s.length()) {
            if (count == 0) { set.add(sb.toString()); }
            return;
        }
        if (count < 0) {
            return;
        }

        int curLen = sb.length();
        char c = s.charAt(start);
        if (c == '(') {
            sb.append(c);
            backTrace(s, sb, count + 1, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
            if (leftRe > 0) {
                backTrace(s, sb, count, start + 1, leftRe - 1, rightRe, set);
            }
        } else if (c == ')') {
            sb.append(c);
            backTrace(s, sb, count - 1, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
            if (rightRe > 0) {
                backTrace(s, sb, count, start + 1, leftRe, rightRe - 1, set);
            }
        } else {
            sb.append(c);
            backTrace(s, sb, count, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
        }
    }

    private List<String> removeInvalidParentheses1(String s) {
        int leftRe = 0, rightRe = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++leftRe;
            } else if (c == ')') {
                if (leftRe > 0) {
                    --leftRe;
                } else {
                    ++rightRe;
                }
            }
        }

        Set<String> set = new HashSet<>();
        backTrace(s, new StringBuilder(), 0, 0, leftRe, rightRe, set);

        return new ArrayList<>(set);
    }

    public List<String> removeInvalidParentheses(String s) {
        return removeInvalidParentheses2(s);  
    }
}

