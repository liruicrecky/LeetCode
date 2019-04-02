/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.56%)
 * Total Accepted:    187.3K
 * Total Submissions: 346.9K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    private List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

       PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(m.get(b), m.get(a)));

       for (int c : m.keySet()) {
           heap.add(c);
           if (heap.size() > k) {
               heap.poll();
           }
       }

       List<Integer> res = new ArrayList<>(k);
       while (!heap.isEmpty()) {
           res.add(heap.poll());
       }
       //Collections.reverse(res);
       return res;
    }

    private List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        if (m.size() == 1) {
            res.add(nums[0]);
            return res;
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e2.getValue().compareTo(e1.getValue()));

        int i = 0;
        for (Map.Entry<Integer, Integer> l : list) {
            if (i == k) { break; }
            res.add(l.getKey());
            i++;
        }

        return res;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        return topKFrequent2(nums, k);
    }
}

