class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) { return res; }
        Map<String, String> m = new HashMap<>();
        m.put("2", "abc");
        m.put("3", "def");
        m.put("4", "ghi");
        m.put("5", "jkl");
        m.put("6", "mno");
        m.put("7", "pqrs");
        m.put("8", "tuv");
        m.put("9", "wxyz");
        backTrace(res, m, new StringBuilder(), digits);
        return res;
    }
    
    private void backTrace(List<String> res, Map<String, String> m, StringBuilder sb, String digits) {
        if (digits.length() == 0) {
            res.add(sb.toString());
        } else {
            String t = digits.substring(0, 1);
            String d = m.get(t);
            for (int i = 0; i < d.length(); i++) {
                String l = d.substring(i, i + 1);
                sb.append(l);
                backTrace(res, m, sb, digits.substring(1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}