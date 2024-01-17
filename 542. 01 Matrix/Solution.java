class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dRow = new int[]{-1, 1,  0, 0}; 
        int[] dCol = new int[]{ 0, 0, -1, 1};
        
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new int[] {row, col});
                } else {
                    mat[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int row = currentCell[0];
            int col = currentCell[1];
            int current = mat[row][col];
            // Check the neighbor cells. If the value is more than 1 above the current one,
            // then it still needs to be processed. Give it a value and add it to the queue.
            for (int i = 0; i < dRow.length; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                
                if (isInBounds(mat, newRow, newCol) && mat[newRow][newCol] - current > 1) {
                    mat[newRow][newCol] = current + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
    
    private boolean isInBounds(int[][] mat, int row, int col) {
        return row >= 0 && row < mat.length 
            && col >= 0 && col < mat[0].length;
    }
}