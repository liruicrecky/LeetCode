class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<String, String> m = new HashMap<>(8);
        m.put("2", "abc");
        m.put("3", "def");
        m.put("4", "ghi");
        m.put("5", "jkl");
        m.put("6", "mno");
        m.put("7", "pqrs");
        m.put("8", "tuv");
        m.put("9", "wxyz");

        List<String> res = new ArrayList<>();
        backTrace(res, new StringBuilder(), m, digits);
        return res;
    }

    private void backTrace(List<String> res, StringBuilder sb, Map<String, String> m, String digits) {
        if (digits.length() == 0) {
            res.add(sb.toString());
        } else {
            String key = digits.substring(0, 1);
            String val = m.get(key);
            for (int i = 0; i < val.length(); i++) {
                String letter = val.substring(i, i + 1);
                sb.append(letter);
                backTrace(res, sb, m, digits.substring(1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}