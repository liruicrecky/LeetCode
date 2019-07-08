import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(s, new Comparator<String>() {
            @Override
             public int compare(String o1, String o2) {
                 String s1 = o1 + o2;
                 String s2 = o2 + o1;
                 return s1.compareTo(s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String i : s) {
            sb.append(i);
        }
        return sb.toString();
    }
}