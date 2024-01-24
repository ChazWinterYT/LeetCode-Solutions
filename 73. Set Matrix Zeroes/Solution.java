class Solution {
    int[][] matrix;
    
    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        
        // Find the original zeroes
        Set<int[]> zeroes = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroes.add(new int[]{row, col});
                }
            }
        }
        
        // Fill only at the original zeroes
        for (int[] zeroPosition : zeroes) {
            int row = zeroPosition[0];
            int col = zeroPosition[1];
            setRowToZero(row);
            setColToZero(col);
        }
    }
    
    private void setRowToZero(int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }
    
    private void setColToZero(int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }
}