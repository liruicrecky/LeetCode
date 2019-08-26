class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) {
            return new int[] {};
        }
        
        int[] res = new int[T.length];
        int i = T.length - 2;
        while (i >= 0) {
            if (T[i + 1] > T[i]) {
                res[i] = 1;
                --i;
            } else {
                int j = i + 1;
                while (res[j] != 0) {
                    j += res[j];
                    if (T[j] > T[i]) {
                        res[i] = j - i;
                         break;
                    }
                }
                --i;
            }
        }
        
        return res;
    }
    
    public int[] dailyTemperatures2(int[] T) {
        if (T.length == 0) {
            return new int[] {};
        }
        
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        
        return res;
    }
    
    public int[] dailyTemperatures1(int[] T) {
        if (T.length == 0) {
            return new int[] {};
        }
        
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j = i + 1;
            while (j < T.length && T[j] <= T[i]) {
                ++j;
            }
            res[i] = j == T.length ? 0 : j - i;
        }
        
        return res;
    }
}