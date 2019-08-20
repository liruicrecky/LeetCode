class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, reset = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, prevSold);
        }
        
        return Math.max(sold, reset);
    }
}1