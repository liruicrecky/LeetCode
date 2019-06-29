public class Solution {
    public void reOrderArray(int [] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int cOdd = 0, cEven = 0;
        for (int i : array) {
            if ((i & 1) == 1) {
                odd[cOdd++] = i;
            } else {
                even[cEven++] = i;
            }
        }
        
        for (int i = 0; i < cOdd; i++) {
            array[i] = odd[i];
        }
        
        for (int i = 0; i < cEven; i++) {
            array[i + cOdd] = even[i];
        }
    }
}