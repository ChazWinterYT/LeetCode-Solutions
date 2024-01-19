class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        //first [ ] is the point, second [ ] is x (0) or y (1) coordinate
        int deltaY = coordinates[1][1] - coordinates[0][1];
        int deltaX = coordinates[1][0] - coordinates[0][0];
        for (int i = 1; i < coordinates.length; i++) {
            int testDeltaY = coordinates[i][1] - coordinates[i-1][1];
            int testDeltaX = coordinates[i][0] - coordinates[i-1][0];
            if (deltaY * testDeltaX != deltaX * testDeltaY) return false; 
        }
        //if the loop survives, then all points are colinear
        return true;
    }
}