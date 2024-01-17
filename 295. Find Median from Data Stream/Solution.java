class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Handle first value in the data stream (send it to lowerHalf).
        if (lowerHalf.isEmpty()) {
            lowerHalf.offer(num);
            return;
        }
        // Send larger numbers to the upperHalf, everything else to lowerHalf.
        if (num > lowerHalf.peek()) {
            upperHalf.offer(num);
        } else {
            lowerHalf.offer(num);
        }
        /* Balance the heaps. If they differ in size by more than 1, 
            swap a value from the larger heap to the smaller heap. */
        if (lowerHalf.size() - upperHalf.size() > 1) { // lowerHalf size too big
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() - lowerHalf.size() > 1) { // upperHalf size too big
            lowerHalf.offer(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        if (lowerHalf.isEmpty()) return 0.0;
        /* If the heaps are the same size, median is the mean of the top of both heaps.
            If they are different sizes, it's the top of whichever heap is larger. */
        if (upperHalf.size() == lowerHalf.size()) { // Same size
            return (upperHalf.peek() + lowerHalf.peek()) / 2.0;
        } else if (upperHalf.size() > lowerHalf.size()) { // upperHalf larger 
            return upperHalf.peek();
        } else { // lowerHalf larger
            return lowerHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
Size    Median index
1       0
3       1
5       2
7       3
formula: size / 2     

Size    Median indices
2       0, 1
4       1, 2
6       2, 3
8       3, 4
formula: size / 2, and (size / 2) - 1   if size > 0

*/