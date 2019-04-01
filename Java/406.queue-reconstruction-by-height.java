/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (59.02%)
 * Total Accepted:    74K
 * Total Submissions: 125K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> 
            p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p2[0], p1[0])
        );
  
        for (int i = 1; i < people.length; i++) {
            int index = people[i][1];
            int[] tmp = people[i];
            int j = i - 1;
            while (j >= index) {
                people[j + 1] = people[j];
                --j;
            }
            people[index] = tmp;
        }
        return people;
    }
}

