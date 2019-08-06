class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            int[] hash = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                hash[s.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(hash);
            List<String> list = m.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            m.put(key, list);
        }

        return new ArrayList<>(m.values());
    }
}