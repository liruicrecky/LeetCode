import java.lang.Character;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] charArr = str.toCharArray();
        int[] hashUp = new int[27];
        int[] hashDown = new int[27];
        for (char c : charArr) {
            if (Character.isUpperCase(c)) {
                hashUp[c - 'A']++;
            } else {
                hashDown[c - 'a']++;
            }
        }

        int len = str.length();
        int res = -1;
        for (int i = 0;i < len;i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                if (hashUp[str.charAt(i) - 'A'] == 1) {
                    res = i;
                    break;
                }
            } else {
                if (hashDown[str.charAt(i) - 'a'] == 1) {
                    res = i;
                    break;
                }
            }
        }

        return res;
    }
}