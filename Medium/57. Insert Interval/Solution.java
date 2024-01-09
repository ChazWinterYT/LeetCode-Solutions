class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If the current interval goes before the new one, just add it to the List
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // If the current interval goes after the new one, insert the new one,
                // then insert the rest by changing newInterval to be the current one
                result.add(newInterval);
                newInterval = interval;
            } else {
                // There is an overlap. Merge the intervals.
                newInterval = mergeIntervalsIfOverlap(interval, newInterval);
            }
        }
        
        /**
        * At the end, either only the new interval will remain (because it was after everything),
        * or there will be one last "newInterval" (because newInterval was already inserted, but
        * we assigned the last interval to newInterval), or the last thing we did was merge intervals
        * (but never added it to the list). So we need to add the last "newInterval" now.
        **/
        result.add(newInterval);
        
        return result.toArray(new int[result.size()][2]);
    }
    
    private int[] mergeIntervalsIfOverlap(int[] interval1, int[] interval2) {
        int[] newInterval = new int[2];
        
        newInterval[0] = Math.min(interval1[0], interval2[0]);
        newInterval[1] = Math.max(interval1[1], interval2[1]);
        
        return newInterval;
    }
}