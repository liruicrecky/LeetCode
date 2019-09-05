class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>(k);
        Map<String, Integer> m = new HashMap<>();

        for (String s : words) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> que = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (m.get(s1) == m.get(s2)) {
                    return s1.compareTo(s2);
                } else {
                    return m.get(s2) - m.get(s1);
                }
            }
        });

        que.addAll(m.keySet());
        while (k-- > 0) {
            if (!que.isEmpty()) {
                res.add(que.poll());
            }
        }

        return res;
    }
}