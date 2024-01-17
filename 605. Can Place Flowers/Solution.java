class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check all reasons to NOT place a flower, and then place one if it's okay
            if (flowerbed[i] == 1) continue;
            if (i > 0 && flowerbed[i-1] == 1) continue;
            if (i < flowerbed.length - 1 && flowerbed[i+1] == 1) continue;
            flowerbed[i] = 1;
            if (--n == 0) return true;
        }
        // If the loop survives, then you still have unplanted flowers
        return false;
    }
}