/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (65.95%)
 * Likes:    241
 * Dislikes: 38
 * Total Accepted:    22K
 * Total Submissions: 33.3K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 
 * 
 * 
 */
class Solution {
    public List<String> commonChars(String[] A) {
        int[] hash = new int[27];
        int[] t = new int[27];

        for (char c : A[0].toCharArray()) {
            hash[c - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                t[c - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(t[j], hash[j]);
                t[j] = 0;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (hash[i]-- > 0) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }

        return res;
    }
}

