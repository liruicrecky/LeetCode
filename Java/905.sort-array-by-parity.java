/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (72.59%)
 * Likes:    458
 * Dislikes: 52
 * Total Accepted:    97.4K
 * Total Submissions: 134.2K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int s = 0, e = A.length - 1;
        while (s < e) {
            while (s < e && (A[s] & 1) == 0) {
                ++s;
            }

            while (s < e && (A[e] & 1) != 0) {
                --e;
            }

            if (s < e) {
                int t = A[s];
                A[s] = A[e];
                A[e] = t;
            }
        
        }

        return A;
    }
}

