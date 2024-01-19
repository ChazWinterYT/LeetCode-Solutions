class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS, so let's use a Queue
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Capture the initial grid state by counting freshOranges and
        // queuing up rotten oranges for processing
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshOranges == 0) return 0; // No fresh oranges to destroy
        int minutesElapsed = 0;
        
        // Our mission is to ruin all oranges!
        // For the currently ruined oranges, ruin all adjacent oranges. Incr the minute when done.
        // Decr freshOranges when one gets ruined. If we reach zero, then the mission is complete!
        while (!queue.isEmpty() && freshOranges > 0) {
            // Each cycle depends on the starting size of the queue
            int queueSizeThisMinute = queue.size();
            for (int i = 0; i < queueSizeThisMinute; i++) {
                int[] currentBadOrange = queue.poll();
                freshOranges = ruinOranges(currentBadOrange, grid, freshOranges, queue);
            }
            minutesElapsed++;
        }
        // If there are zero freshOranges, then the mission passed. Return the minutesElapsed.
        // If there are still freshOranges left, then the mission failed. Return -1.
        return freshOranges == 0 ? minutesElapsed : -1;
    }
    
    private int ruinOranges(int[] badOrange, int[][] grid, int freshOranges, Queue<int[]> queue) {
        int row = badOrange[0], col = badOrange[1];
        // Try to ruin oranges in four directions. Decr freshOranges with each success
        // Also add the newly ruined orange to the queue so it can ruin more!
        int[] dRow = new int[]{-1, 1,  0, 0};
        int[] dCol = new int[]{ 0, 0, -1, 1};
        for (int i = 0; i < dRow.length; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (isInBounds(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 2;
                freshOranges--;
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return freshOranges;
    }
    
    private boolean isInBounds(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length
            && col >= 0 && col < grid[0].length;
    }
}