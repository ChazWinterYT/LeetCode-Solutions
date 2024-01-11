class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    weFoundLand(grid, row, col);
                }
            }
        }
        return numIslands;
    }
    
    private void weFoundLand(char[][] grid, int row, int col) {
        // Do nothing if the current cell is out of bounds or zero
        if (row < 0 || row >= grid.length
           || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        
        // Mark current cell as water so it's not checked again
        grid[row][col] = '0';
        
        // Visit all adjacent cells to check for land
        weFoundLand(grid, row-1, col);    // Up
        weFoundLand(grid, row+1, col);    // Down
        weFoundLand(grid, row, col-1);    // Left
        weFoundLand(grid, row, col+1);    // Right
    }
}