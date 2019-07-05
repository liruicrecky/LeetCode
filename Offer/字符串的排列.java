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
}