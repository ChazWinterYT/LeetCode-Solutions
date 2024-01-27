class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // Do three rotations of the input matrix, and make sure one of them matches the target.
        // Also check the original before the first rotation, in case they started off equal.
        for (int i = 0; i < 4; i++) {
            if (arraysEqual(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;   // None of the three rotations matched the target.
    }
    
    // This is literally the solution to LeetCode 48: Rotate Image.
    private void rotate(int[][] matrix) {
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
    
    private boolean arraysEqual(int[][] matrix, int[][] target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] != target[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}