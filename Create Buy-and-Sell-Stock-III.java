class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] after = new int[2][3];

        for (int i = n - 1; i >= 0; i--){
            int[][] curr = new int[2][3];
            for (int j = 1; j >= 0; j--){
                for (int k = 1; k >= 0; k--){
                    int skip = after[j][k];

                    if (j == 1) curr[j][k] = Math.max(skip, after[0][k] - prices[i]);
                    else curr[j][k] = Math.max(skip, after[1][k + 1] + prices[i]);
                }
            }

            after = curr;
        }

        return after[1][0];
    }
}
