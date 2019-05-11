/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar1(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)) == 1) {
                res = i;
                break;
            }
        }

        return res;
    }

    public int firstUniqChar(String s) {
       int[] hash = new int[26];
       int[] index = new int[26];

       int i = 0;
       for (char c : s.toCharArray()) {
           hash[c - 'a']++;
           if (hash[c - 'a'] == 1) {
               index[c - 'a'] = i;
           }
           ++i;
       }

       int first = Integer.MAX_VALUE;
       for (int j = 0; j < 26; j++) {
           if (hash[j] == 1) {
                if (index[j] < first) {
                    first = index[j];
                }
           }
       }

       return first == Integer.MAX_VALUE ? -1 : first;
    }
}

