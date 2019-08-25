class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        List<Integer> res = new ArrayList<>();
        if (lenP > lenS) {
            return res;
        }

        Map<Character, Integer> m = new HashMap<>();
        for (char c : p.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int size = m.size();

        while (end < lenS) {
            char tc = s.charAt(end);
            if (m.containsKey(tc)) {
                m.put(tc, m.get(tc) - 1);
                if (m.get(tc) == 0) {
                    --size;
                }
            }
            ++end;

            while (size == 0) {
                tc = s.charAt(start);
                if (m.containsKey(tc)) {
                    m.put(tc, m.get(tc) + 1);
                    if (m.get(tc) > 0) {
                        ++size;
                    }
                }

                if (end - start == lenP) {
                    res.add(start);
                }

                ++start;
            }
        }

        return res;
    }
}