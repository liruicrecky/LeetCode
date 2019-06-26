public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int len = str.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        
        return sb.toString();
    }
}