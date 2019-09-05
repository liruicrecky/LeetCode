class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int len = s.length();
        int index = 0, incre = 1;
        for (int i = 0; i < len; i++) {
            sbs[index].append(s.charAt(i));
            if (index == 0) {
                incre = 1;
            }
            if (index == numRows - 1) {
                incre = -1;
            }
            index += incre;
        }

        for (int i = 1; i < numRows; i++) {
            sbs[0].append(sbs[i]);
        }

        return sbs[0].toString();
    }
}