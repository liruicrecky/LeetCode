/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (30.33%)
 * Total Accepted:    165.6K
 * Total Submissions: 540.3K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
class Solution {

    private int largestRectangleArea2(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (i - j + 1));
            }
        }
        return max;
    }

    private int largestRectangleArea1(int[] heights) {
        int largest = 0;
        Deque<Integer> minV = new LinkedList<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!minV.isEmpty() && (i == heights.length || heights[minV.peek()] > heights[i])) {
                int j = minV.pop();       
                largest = Math.max(largest, heights[j] * (minV.isEmpty() ? i : i - minV.peek() - 1));
           }

           minV.push(i);
        }

        return largest;
    }

    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea1(heights);
    }
}

