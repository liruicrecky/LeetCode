class Solution {
    public int numSquares(int n) {
        Deque<Integer> que = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        que.offer(0);
        set.add(0);

        int level = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int cur = que.poll();
                for (int i = 1; i * i <= n; i++) {
                    int cal = cur + i * i;
                    if (cal == n) {
                        return level + 1;
                    }
                    if (!set.contains(cal)) {
                        set.add(cal);
                        que.offer(cal);
                    }
                }
            }
            ++level;
        }

        return 0;
    }

    public int numSquares1(int n) {
        if (n < 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}