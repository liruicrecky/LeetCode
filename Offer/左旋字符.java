public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || n <= 0 || str.length() == 0) {
            return str;
        }

        int len = str.length();
        n %= len;

        str = help(str, 0, n - 1);
        str = help(str, n, len - 1);
        return help(str, 0, len - 1);
    }

    private String help(String str, int s, int e) {
        char[] arr = str.toCharArray();
        while (s < e) {
            char c = arr[s];
            arr[s] = arr[e];
            arr[e] = c;
            ++s;
            --e;
        }

        return String.valueOf(arr);
    }

    public String LeftRotateString1(String str, int n) {
        if (str == null || n <= 0 || str.length() == 0) {
            return str;
        }

        int len = str.length();
        n %= len;

        String s1 = str.substring(0, n);
        String s2 = str.substring(n, len);
        return s2 + s1;
    }
}