class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        
        int testColor = image[sr][sc];
        image[sr][sc] = color;
        
        int[] dRow = {-1, 1,  0, 0};
        int[] dCol = { 0, 0, -1, 1};
        
        
        for (int i = 0; i < 4; i++) { // Four directions
            int newRow = sr + dRow[i];
            int newCol = sc + dCol[i];
            
            if (newRow >= 0 && newRow < image.length && newCol >=0 && newCol < image[0].length
                        && image[newRow][newCol] == testColor) {
                floodFill(image, newRow, newCol, color);
            }
        }
        return image;
    }
}