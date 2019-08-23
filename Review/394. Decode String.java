class Solution {
    public String decodeString(String s) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();

        int times = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                times = times * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(times);
                strStack.push(cur);
                cur = new StringBuilder();
                times = 0;
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (times = numStack.pop(); times > 0; times--) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}