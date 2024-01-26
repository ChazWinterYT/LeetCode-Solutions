class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // Deque to store indices of the largest values of the array, in decreasing order.
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove the indices that are outside the current window
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                int x = queue.poll();
            }
            // Remove any values that are smaller than the value incoming to the window
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
                
            }
            // The incoming value is therefore the smallest in the Deque. Add it to the back.
            queue.offer(i);
            
            // The index at the front of the Deque holds the max value. Add it to the result
            // (but only if we're in a valid window!)
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
}

/*      Original solution, too slow!

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        int max = getLocalMax(nums, 0, k);
        result[index++] = max;
        
        
        for (int i = 1; i <= nums.length - k; i++) {
            int newValue = nums[i + k - 1];
            int oldValue = nums[i - 1];
            // If the new value is greater than the current max, it's the new max.
            if (newValue > max) {
                max = newValue;
            }
            // If the current max leaves the window, we need to recalculate the max.
            else if (oldValue == max) {
                max = getLocalMax(nums, i, i + k); 
            }
            // Otherwise, the max is just the same as it was before. Regardless, put it in the array.
            result[index++] = max;
        }
        return result;
    }
    
    private int getLocalMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, nums[i]);
        } 
        return max;
    }
}

*/