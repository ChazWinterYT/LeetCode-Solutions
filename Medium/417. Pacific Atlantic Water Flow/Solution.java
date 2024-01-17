class Solution {
    int height;
    int width;
    boolean[][] canReachAtlantic;
    boolean[][] canReachPacific;
    int[] dRow = new int[] {-1, 0, 1, 0}; // Up, Left, Down, Right
    int[] dCol = new int[] {0, -1, 0, 1};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        height = heights.length;
        width = heights[0].length;
        canReachAtlantic = new boolean[height][width];
        canReachPacific = new boolean[height][width];
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 || col == 0) {
                    dfs(heights, row, col, "Pacific");
                } 
                if (row == height - 1 || col == width - 1) {
                    dfs(heights, row, col, "Atlantic");
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (canReachAtlantic[row][col] && canReachPacific[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, int row, int col, String ocean) {
        // If this cell is already true, don't calculate it again. If it's not, mark it true.
        if (ocean.equals("Atlantic")) {
            if (canReachAtlantic[row][col]) return;
            canReachAtlantic[row][col] = true;
        }
        if (ocean.equals("Pacific")) {
            if (canReachPacific[row][col]) return;
            canReachPacific[row][col] = true;
        }
        
        for (int i = 0; i < 4; i++) {   // Four directions
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (isInBounds(newRow, newCol) && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, ocean);
            }
        }
    }
    
    // Helper method to determine if a cell is in bounds
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < height 
            && col >= 0 && col < width;
    }
}