class Solution {
    int[] dRow = {0, 1, 0, -1};
    int[] dCol = {1, 0, -1, 0};
    int row = 0, col = 0;
    public static final int COMPLETED_CELL = -101; // no cells can ever start with this value
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        result.add(matrix[row][col]);   // Add (0, 0) to the List at the start
        matrix[row][col] = COMPLETED_CELL; // Mark (0, 0) complete
        int newRow = row, newCol = col;
        
        do {
            for (int i = 0; i < 4; i++) {   // Four directions
                newRow = row + dRow[i]; // Look at the next cell
                newCol = col + dCol[i];
                // First make sure you CAN move in that direction. Then move until you can't.
                if (isInBoundsAndNotVisited(matrix, newRow, newCol)) {
                    while (isInBoundsAndNotVisited(matrix, newRow, newCol)) {
                        result.add(matrix[newRow][newCol]);     // Add the cell
                        matrix[newRow][newCol] = COMPLETED_CELL;    // Mark it complete
                        row = newRow;   // Remember it
                        col = newCol;
                        newRow = newRow + dRow[i];  // Look at the next cell
                        newCol = newCol + dCol[i];
                    }
                }
            }
        } while (!finished(matrix, row, col));
        
        return result;
    }
    
    // Helper method to determine if we finished the problem already
    private boolean finished(int[][] matrix, int row, int col) {
        for (int i = 0; i < 4; i++) {   // Four directions
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (isInBoundsAndNotVisited(matrix, newRow, newCol)) {
                return false;
            }
        }
        return true;
    }
    
    // Helper method to determine if a cell is in bounds and not already completed
    private boolean isInBoundsAndNotVisited(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
            && matrix[row][col] != COMPLETED_CELL;
    }
}