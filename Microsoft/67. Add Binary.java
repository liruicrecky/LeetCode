class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length() - 1, lenB = b.length() - 1;
        int carry = 0;

        while (lenA >= 0 || lenB >= 0) {
            int sum = carry;
            if (lenA >= 0) {
                sum += a.charAt(lenA) - '0';
                --lenA;
            }
            if (lenB >= 0) {
                sum += b.charAt(lenB) - '0';
                --lenB;
            }

            carry = sum >>> 1;
            sb.append(sum % 2);
        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}