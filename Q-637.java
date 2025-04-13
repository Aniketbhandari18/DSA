class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        int[] dp = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++){
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    if (dp[j] >= dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[j] == dp[i] - 1) count[i] += count[j];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            if (dp[i] == maxLen) ans += count[i];
        }

        return ans;
    }
}
