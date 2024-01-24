class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }  
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
        
    /*      Old solution, less efficient
        int maxProfit = 0;
        //two pointers to track the sliding window
        int left = 0, right = 1;
        //when the right pointer reaches the end, we'll return an answer
        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            if (profit > maxProfit) maxProfit = profit;
            //if we find a lower value on the right, move the left pointer to that spot
            if (prices[right] <= prices[left]) {
                left = right;
                right++;
            } else { //otherwise, just slide the right pointer
                right++;
            }
        }
        return maxProfit;
        */
    }
}
