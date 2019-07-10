import java.util.HashMap;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }
        
        int firstOne = findFirstBitOne(xor);
        int n1 = 0, n2 = 0;
        for (int i : array) {
            if (isBitOne(i, firstOne)) {
                n1 ^= i;
            } else {
                n2 ^= i;
            }
        }

        num1[0] = n1;
        num2[0] = n2;
    }

    private boolean isBitOne(int n, int index) {
        n >>= index;
        return (n & 1) == 1;
    }

    private int findFirstBitOne(int n) {
        int index = 0;
        while ((n & 1) == 0) {
            n >>= 1;
            ++index;
        }

        return index;
    }

    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : array) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }

        boolean first = true;
        for (int i : array) {
            if (m.get(i) == 1 && first) {
                num1[0] = i;
                first = false;
            } else if (m.get(i) == 1 && !first){
                num2[0] = i;
            }
        }
    }
}