class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>(len);

        for (char c : arr) {
            switch (c) {
            case '[':
            case '(':
            case '{':
                stack.push(c);
                break;
            case ']':
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            case ')':
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                break;
            case '}':
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
            default:
                break;
            }
        }

        return stack.isEmpty() ? true : false;
    }
}