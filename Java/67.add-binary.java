/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.04%)
 * Total Accepted:    291.2K
 * Total Submissions: 754.3K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        int aa, bb, c;

        while (indexA >= 0 && indexB >= 0) {
            aa = a.charAt(indexA--) - '0';
            bb = b.charAt(indexB--) - '0';
            c = carry ? aa + bb + 1 : aa + bb;

            if (c > 1) {
                carry = true;
                c %= 2;
            } else {
                carry = false;
            }
            sb.append(c);
        }

        while (indexA >= 0) {
            aa = a.charAt(indexA--) - '0';
            c = carry ? aa + 1 : aa;

            if (c > 1) {
                carry = true;
                c %= 2;
            } else {
                carry = false;
            }
            sb.append(c);
        }

        while (indexB >= 0) {
            bb = b.charAt(indexB--) - '0';
            c = carry ? bb + 1 : bb;

            if (c > 1) {
                carry = true;
                c %= 2;
            } else {
                carry = false;
            }
            sb.append(c);
        }

        if (carry) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}

