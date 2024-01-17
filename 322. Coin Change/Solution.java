class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; //this is an impossible number of coins
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return (dp[amount] != max) ? dp[amount] : -1;
    }
    
    
    /**
    * my first attempt
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount > 0 && Arrays.equals(coins, new int[]{1})) return amount;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
    */
}

