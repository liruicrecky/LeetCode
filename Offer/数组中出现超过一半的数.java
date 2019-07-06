public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (res == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = array[i];
                    count = 1;
                }
            }
        }
        
        count = 0;
        for (int i : array) {
             if (i == res) {
                 count++;
             }
        }
        
        return count > (array.length >> 1) ? res : 0;
    }
}