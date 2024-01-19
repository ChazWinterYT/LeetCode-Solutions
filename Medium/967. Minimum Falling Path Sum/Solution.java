class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        int[][] minTree = new int [matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++)  minTree[0][i] = matrix[0][i];
        for (int i = 1; i < matrix.length; i++) { 
            System.out.println("Row " + i);
            for (int j = 0; j < matrix[i].length; j++) {  
                if (j == 0) {
                    int center = minTree[i - 1][0] + matrix[i][j];
                    int right = minTree[i - 1][1] + matrix[i][j];
                    minTree[i][j] = Math.min(center, right);
                }   else if (j == matrix[i].length - 1) {
                    int left = minTree[i - 1][matrix[i].length - 2] + matrix[i][j];
                    int center = minTree[i - 1][matrix.length - 1] + matrix[i][j];
                    minTree[i][j] = Math.min(left, center);
                }   else {
                    int left = minTree[i - 1][j - 1] + matrix[i][j];
                    int center = minTree[i - 1][j] + matrix[i][j];
                    int right = minTree[i - 1][j + 1] + matrix[i][j];
                    minTree[i][j] = Math.min(left, Math.min(center, right));
                }
            }
        }
        for (int k = 0; k < minTree.length; k++) {
            if (minTree[minTree.length - 1][k] < minSum) {
                minSum = minTree[minTree.length - 1][k];
            }
        }
        return minSum;
    }
}