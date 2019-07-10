public class Solution {
    public String ReverseSentence(String str) {
        if (str.length() == 1 || str.length() == 0 || str == null) {
            return str;
        }

        char[] arr = str.toCharArray();
        int len = arr.length;
        int i = 0, j = 0;
        while (i < len) {
            while (j < len && arr[j] != ' ') {
                ++j;
            }
            reverse(arr, i, j - 1);
            ++j;
            i = j;
        }
        reverse(arr, 0, len - 1);
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int s, int e) {
        while (s < e) {
            char c = arr[s];
            arr[s] = arr[e];
            arr[e] = c;
            ++s;
            --e;
        }
    }
}