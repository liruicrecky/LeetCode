class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        help(s, res, 0, 0, '(', ')');
        return res;
    }

    private void help(String s, List<String> res, int iStr, int jStr, char open, char close) {
        int count = 0, len = s.length();
        for (int i = iStr; i < len; i++) {
            if (s.charAt(i) == open) {
                ++count;
            } else if (s.charAt(i) == close) {
                --count;
            }

            if (count >= 0) {
                continue;
            }

            for (int j = jStr; j <= i; j++) {
                if (s.charAt(j) == close && (j == 0 || s.charAt(j - 1) != close)) {
                    help(s.substring(0, j) + s.substring(j + 1), res, i, j, open, close);
                }
            }

            return;
        }

        String rev = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            help(rev, res, 0, 0, ')', '(');
        } else {
            res.add(rev);
        }
    }

    public List<String> removeInvalidParentheses2(String s) {
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

        Set<String> res = new HashSet<>();
        backTrace(s, new StringBuilder(), 0, 0, leftRe, rightRe, res);

        return new ArrayList<>(res);
    }

    private void backTrace(String s, StringBuilder sb, int count, int start, int leftRe, int rightRe, Set<String> set) {
        if (start == s.length()) {
            if (count == 0) {
                set.add(sb.toString());
            }
            return;
        }

        if (count < 0) {
            return;
        }

        int curLen = sb.length();
        char c = s.charAt(start);

        switch (c) {
        case '(':
            sb.append(c);
            backTrace(s, sb, count + 1, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
            if (leftRe > 0) {
                backTrace(s, sb, count, start + 1, leftRe - 1, rightRe, set);
            }
            break;
        case ')':
            sb.append(c);
            backTrace(s, sb, count - 1, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
            if (rightRe > 0) {
                backTrace(s, sb, count, start + 1, leftRe, rightRe - 1, set);
            }
            break;
        default:
            sb.append(c);
            backTrace(s, sb, count, start + 1, leftRe, rightRe, set);
            sb.setLength(curLen);
            break;
        }
    }

    public List<String> removeInvalidParentheses1(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        Queue<String> que = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        que.offer(s);
        set.add(s);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                String t = que.poll();
                if (isVaild(t)) {
                    res.add(t);
                } else {
                    int len = t.length();
                    for (int i = 0; i < len; i++) {
                        if (Character.isLetter(t.charAt(i))) {
                            continue;
                        }

                        String sub = t.substring(0, i) + t.substring(i + 1);
                        if (!set.contains(sub)) {
                            set.add(sub);
                            que.offer(sub);
                        }
                    }
                }
            }
            if (res.size() > 0) {
                break;
            }
        }

        if (res.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append(c);
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    private boolean isVaild(String s) {
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
}