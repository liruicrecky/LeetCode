import java.util.Arrays;
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length <= 0) {
            return false;
        }
        
        int len = sequence.length;
        int root = sequence[len - 1];
        
        int i = 0;
        for (; i < len - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        
        int j = i;
        for (; j < len - 1; j++) {
            if (root > sequence[j]) {
                return false;
            }
        }
        
        boolean left = true, right = true;
        if (i > 0) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        if (i < len - 1) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i + 1, len));
        }
        return left && right;
    }
}