class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;
        int oneBuySell = 0;
        int twoBuySell = 0;

        for (int price : prices) {
            oneBuy = Math.min(oneBuy, price);
            oneBuySell = Math.max(oneBuySell, price - oneBuy);
            twoBuy = Math.min(twoBuy, price - oneBuySell);
            twoBuySell = Math.max(twoBuySell, price - twoBuy);
        }

        return twoBuySell;
    }
}