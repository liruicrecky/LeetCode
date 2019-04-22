/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.37%)
 * Total Accepted:    134.5K
 * Total Submissions: 410.3K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {

    private int _k = 0;

    private void help(int[] arr, List<Integer> t, StringBuilder sb) {
       if (t.size() == arr.length) {
           --_k;
           if (_k <= 0) {
               for (int i : t) {
                    sb.append(i);
               }
               
           }
       } else if (_k > 0) {
           for (int i = 0; i < arr.length; i++) {
               if (t.contains(arr[i])) {
                   continue;
               }
               t.add(arr[i]);
               help(arr, t, sb);
               t.remove(t.size() - 1);
           }
       }
    }

    private String getPermutation1(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        _k = k;

        StringBuilder res = new StringBuilder();
        help(arr, new ArrayList<>(), res);
        return res.toString();
    }

    public String getPermutation(int n, int k) {
        return getPermutation1(n, k);
    }
}

