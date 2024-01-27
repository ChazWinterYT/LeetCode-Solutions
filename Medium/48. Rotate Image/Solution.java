class Solution {
    public void rotate(int[][] matrix) {
        int width = matrix.length;
        /* To rotate an array 90 degrees, you flip it along a 45 degree angle (change all 
            [row][col] to [col][row]), then reverse each row. */
        
        for (int row = 0; row < width; row++) {
            for (int col = row; col < width; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        
        // Now reverse each row
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][width - col - 1];
                matrix[row][width - col - 1] = temp;
            }
        }
    }
}