class Solution {
    public int coinChange2(int[] coins, int amount) {
        int[] res = new int[] { amount + 1 };
        Arrays.sort(coins);
        backTrace(coins, amount, coins.length - 1, new ArrayList<Integer>(), res);
        return res[0] > amount ? -1 : res[0];
    }

    private void backTrace(int[] coins, int remain, int start, List<Integer> list, int[] res) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res[0] = Math.min(res[0], list.size());
            return;
        }

        for (int i = start; i >= 0; i--) {
            list.add(coins[i]);
            backTrace(coins, remain - coins[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        return help(coins, amount, new int[amount]);
    }

    private int help(int[] coins, int left, int[] memo) {
        if (left == 0) {
            return 0;
        }

        if (left < 0) {
            return -1;
        }

        if (memo[left - 1] != 0) {
            return memo[left - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = help(coins, left - coin, memo);
            if (min > res && res >= 0) {
                min = res + 1;
            }
        }

        return memo[left - 1] = min == Integer.MAX_VALUE ? -1 : min;
    }
}