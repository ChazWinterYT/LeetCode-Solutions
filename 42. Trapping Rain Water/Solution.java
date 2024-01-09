class Solution {
    public int trap(int[] height) {
        int water = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int currentMax = 0;   

        //iterate through height array. determine the max height
        //of the blocks to the left and right of each element
        for (int i = 0; i < maxLeft.length; i++) {
            maxLeft[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]); // Should the current block be the new max?
        }
        currentMax = 0;
        for (int i = maxRight.length - 1; i >= 0; i--) {
            maxRight[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]);
        }

        //just testing the above blocks. this code must be deleted before submission (time limit)
        /*
        for (int i = 0; i < height.length; i++) {
            System.out.printf("For index %d (%d), maxLeft: %d, maxRight %d%n",
                                 i, height[i], maxLeft[i], maxRight[i]);
        }
        */

        //iterate through the array again, this time calculating the 
        //amount of water at each point in the array
        //NOTE: if the calculation ends up negative, don't include it
        for (int i = 0; i < height.length; i++) {
            int waterAtThisLocation = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (waterAtThisLocation < 0) continue;
            water += waterAtThisLocation;
        }
        
        return water;
    }
}