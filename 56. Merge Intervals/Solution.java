class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        // Need to start the List with the first interval
        merged.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            mergeIfOverlap(merged.peekLast(), intervals[i], merged);
        }
        return merged.toArray(new int[merged.size()][]);
    }
    
    /* Helper method that merges intervals.
        If a merge is possible, merge the two intervals, remove the old
        one from the list, and replace it with the merged one.
        Otherwise, just add the new interval to the list.
    */
    private void mergeIfOverlap(int[] first, int[] second, LinkedList<int[]> merged) {
        if (second[0] <= first[1]) {
            merged.pollLast();
            int endInterval = Math.max(first[1], second[1]);
            merged.offerLast(new int[]{first[0], endInterval});
        } else {
            merged.offerLast(second);
        }
    }
}