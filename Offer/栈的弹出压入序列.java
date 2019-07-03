import java.util.ArrayList;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int lenA = pushA.length, lenB = popA.length;
        if (lenA != lenB) {
            return false;
        }
        
        ArrayList<Integer> s = new ArrayList<>(lenA);
        boolean res = true;
        
        int ipush = 0, ipop = 0;
        while (ipop != lenA) {
           while(s.size() == 0 || s.get(s.size() - 1) != popA[ipop]) {
               if (ipush < lenA) {
                   s.add(pushA[ipush++]);
               } else {
                   break;
               }   
           }
            if (s.get(s.size() - 1) != popA[ipop]) {
                res = false;
                break;
            }
            ++ipop;
            s.remove(s.size() - 1);
        }
        
        return res;
    }
}