class Solution {
    private static final int MOD = 1_000_000_007;
    int n;
    
    public int sumSubarrayMins(int[] arr) {
        n = arr.length;
        long sum = 0; // Use long to avoid integer overflow.
        
        /* For each element in arr, store the index of the next smaller element to its left and right. */
        int[] minLeft = findNextSmallestIndexFromLeft(arr);
        int[] minRight = findNextSmallestIndexFromRight(arr);
        
        
        
        
        // For each element, calculate the number of subarrays where this element is the minimum.
        // Then add this element that number of times to the sum.
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * minLeft[i] * minRight[i];
            sum %= MOD;
        }
        
        return (int) sum;
    }
    
    /* As we traverse, pop indexes from the stack until you find one containing a smaller value. 
            Store that index in the min array. Then push the current value's index to the stack so it
            can be used for comparison. This needs to be done twice - from the left and the right. */
    private int[] findNextSmallestIndexFromLeft(int[] arr) {
        int[] minLeft = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            minLeft[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return minLeft;
    }
    
    private int[] findNextSmallestIndexFromRight(int[] arr) {
        int[] minRight = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Use ">= arr" so the right-most instance of an element is always the minimum.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            minRight[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        return minRight;
    }
    
}