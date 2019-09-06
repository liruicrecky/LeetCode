class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return m.get(b) - m.get(a);
            }
        });

        List<Integer> res = new ArrayList<>(k);

        que.addAll(m.keySet());
        while (k-- > 0) {
            if (!que.isEmpty()) {
                res.add(que.poll());
            }
        }

        return res;
    }
}