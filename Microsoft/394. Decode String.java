class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int time = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                time = time * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(time);
                strStack.push(cur);
                time = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (time = numStack.pop(); time > 0; time--) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}