class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int i = 0, base = 0, sign = 1;
        int len = str.length();

        while (i < len && str.charAt(i) == ' ') {
            ++i;
        }

        if (i == len) {
            return 0;
        }

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }

        while (i < len && Character.isDigit(str.charAt(i))) {
            if (base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            base = base * 10 + str.charAt(i++) - '0';
        }

        return base * sign;
    }
}