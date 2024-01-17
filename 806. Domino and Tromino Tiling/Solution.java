class Solution {
    public int numTilings(int n) {
        if (n == 1) return 1;
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        long[] dpPartial = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dpPartial[1] = 0;
        dpPartial[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + 2 * dpPartial[i-1]) % MOD;
            dpPartial[i] = (dpPartial[i-1] + dp[i-2]) % MOD;
        }
        
        return (int) dp[n];
    }
}