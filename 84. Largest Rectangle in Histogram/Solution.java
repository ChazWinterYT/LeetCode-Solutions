class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestRectangle = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int leftIndex = stack.pop();
                int height = heights[leftIndex];
                /* If the stack is empty, this rectangle extends all the way to the left edge of the chart.
                   Otherwise, it extends back to the next rectangle on the stack. */
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                largestRectangle = Math.max(largestRectangle, width * height);
            }
            stack.push(i);
        }
        // There may still be values in the stack. We need to process them.
        while (!stack.isEmpty()) {
            int leftIndex = stack.pop();
            int height = heights[leftIndex];
            int width;
                if (stack.isEmpty()) {
                    width = heights.length;
                } else {
                    width = heights.length - stack.peek() - 1;
                }
            largestRectangle = Math.max(largestRectangle, width * height);
        }
        
        return largestRectangle;
    }
}

/* If the rectangles are in increasing order, then you should keep stacking them, because
   you can keep making the area wider with these rectangles.
   But if you find one smaller, you should now pop from the Stack and get the area of every rectangle
   before the current one (the ones that were taller than the current one).
   The height is the rectangle you popped, and the width is current index - popped index. 
   The more values you pop in a row, the wider that rectangle will be (since the values you popped
   before it were taller, you're okay to use them as part of the latest triangle). 
   Then at the end, you need to build whatever triangles can be formed with the right edge of the chart. */

/*
Brute force solution (exceeds time limit)

    public int largestRectangleArea(int[] heights) {
        int largestRectangle = 0;
        for (int i = 0; i < heights.length; i++) {
            int newRectangle = buildRectangleToLeft(heights, i)
                + buildRectangleToRight(heights, i) - heights[i];   // heights[i] gets counted twice
            largestRectangle = Math.max(largestRectangle, newRectangle);
        }
        return largestRectangle;
    }
    
    private int buildRectangleToLeft(int[] heights, int i) {
        // Start j to the left of i, and keep sliding it left until you can't make a bigger rectangle.
        int j = i - 1;
        while (j >= 0 && heights[i] <= heights[j]) {
            j--;
        }
        // Example, rectangles 4, 3, and 2 form a rectangle. j is actually 1 at this point.
        //   So the width really is just 4 - 1 (i - j). 
        
        return heights[i] * (i - j);
    }
    
    private int buildRectangleToRight(int[] heights, int i) {
        int j = i + 1;
        while (j < heights.length && heights[i] <= heights[j]) {
            j++;
        }
        return heights[i] * (j - i);
    }
*/