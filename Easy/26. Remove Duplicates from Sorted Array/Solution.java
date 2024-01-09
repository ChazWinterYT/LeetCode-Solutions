class Solution {
    public int removeDuplicates(int[] nums) {
        //create two pointers to move through the array, i and j
        int i = 0; int j = 1;
        //create a loop that runs until j reaches the end of the array
        while (j < nums.length) {
            //if index i and j are the same value, just increment j until you reach a unique value
            if (nums[i] == nums[j]) {
                j++;
            } else {
                //when you find a unique value, increment i to the next value in the array,
                //and copy the unique value at j to that next value in the array
                //example: [1, 1, 1, 2, 3] becomes [1, 2, 1, 2, 3] and then [1, 2, 3, 2, 3]
                i++;
                nums[i] = nums[j];
            }
        }
        //the first i+1 values of the array are now unique. return i+1.
        return i+1;
    }
}