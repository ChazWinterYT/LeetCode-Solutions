class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int x : piles) {
            high = Math.max(high, x);
        }
        
        while (low < high) {
            int testSpeed = (low + high) / 2;
            // If she can finish, then the speed could be slower (or this speed is correct)
            if (canFinish(piles, h, testSpeed)) {
                high = testSpeed;
            } else { // If she can't finish, then the speed should be faster
                low = testSpeed + 1;
            }
        }
        return high;
    }
    
    public boolean canFinish(int[] piles, int hoursAvailable, int testSpeed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += Math.ceil(pile / (double) testSpeed);
        }
        return hoursNeeded <= hoursAvailable;
    }
}