class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (m.containsKey(sum - k)) {
                count += m.get(sum - k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}