import java.lang.Character;

public class Solution {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        boolean plus = true;
        int index = 0, len = array.length;
        int res = 0;

        if (!Character.isDigit(array[index])) {
            if (array[index] == '-' || array[index] == '+') {
                if (array[index] == '-') {
                    plus = false;
                }
                ++index;
            } else {
                return 0;
            }
        }

        while (index < len) {
            if (Character.isDigit(array[index])) {
                res = res * 10 + array[index] - '0';
                ++index;
            } else {
                return 0;
            }
        }

        if (!plus) {
            res = 0 - res;
        }

        return res;
    }
}