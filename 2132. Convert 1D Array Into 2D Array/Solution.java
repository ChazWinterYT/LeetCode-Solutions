class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        int[][] result = new int[m][n];
        int origIndex = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = original[origIndex++];
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }
}