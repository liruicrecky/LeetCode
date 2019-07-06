import java.util.ArrayList;
import java.util.TreeSet; 

public class Solution {
    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> tree = new TreeSet<>();
    private void Permutation(char[] str, int start) {
        if (start == str.length)
            tree.add(String.valueOf(str));
        else {
            for (int i = start;i < str.length;i++) {
                char t = str[i];
                str[i] = str[start];
                str[start] = t;
                
                Permutation(str, start + 1);
                
                t = str[i];
                str[i] = str[start];
                str[start] = t;
            }
        }
    }
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0 || str == null)
            return res;
        Permutation(str.toCharArray(), 0);
        res.addAll(tree);
        return res;
    }

    // 组合
    private static void Permutation(ArrayList<String> res, char[] str, int start, int len, StringBuilder sb) {
        if (len == 0) {
            res.add(sb.toString());
        } else if (start == str.length) {
            return;
        } else {
            sb.append(str[start]);
            Permutation(res, str, start + 1, len - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            Permutation(res, str, start + 1, len, sb);
        }
    }

    public static void main(String[] args) {
        String a = "abc";
        char[] c = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= c.length; i++) {
            Permutation(res, c, 0, i, sb);
        }
    }
}