/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */
class Solution {
    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        boolean carry = false;
        int sum = 0, a = 0, b = 0;
        while (l1 >= 0 && l2 >= 0) {
            a = num1.charAt(l1) - '0';
            b = num2.charAt(l2) - '0';
            sum = carry ? a + b + 1 : a + b;
            if (sum > 9 ) {
                carry = true;
            } else {
                carry = false;
            }

            sum %= 10;
            sb.append(sum);
            --l1;
            --l2;
        }

        while (l1 >= 0) {
            a = num1.charAt(l1) - '0';
            sum = carry ? a + 1 : a;
            if (sum > 9) {
                carry = true;
            } else {
                carry = false;
            }
            
            sum %= 10;
            sb.append(sum);
            --l1;
        }

        while (l2 >= 0) {
            a = num2.charAt(l2) - '0';
            sum = carry ? a + 1 : a;
            if (sum > 9) {
                carry = true;
            } else {
                carry = false;
            }
            
            sum %= 10;
            sb.append(sum);
            --l2;
        }

        if (carry) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        boolean carry = false;

        while (l1 >= 0 || l2 >= 0 || carry) {
            int a = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int b = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = carry ? a + b + 1 : a + b;
            if (sum > 9) {
                carry = true;
            } else {
                carry = false;
            }
            sb.append(sum % 10);
            --l1;
            --l2;
        }
        
        return sb.reverse().toString();
    }
}

