class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] next = new int[2];
        int[] secNext = new int[2];

        for (int i = n - 1; i >= 0; i--){
            int[] curr = new int[2];

            for (int j = 1; j >= 0; j--){
                int skip = next[j];

                if (j == 1) curr[j] = Math.max(skip, next[0] - prices[i]);
                else curr[j] = Math.max(skip, secNext[1] + prices[i]);
            }
            secNext = next;
            next = curr;
        }

        return next[1];
    }
}
