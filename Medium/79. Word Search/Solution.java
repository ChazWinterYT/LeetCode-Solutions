class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int index = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (exist(board, visited, word, row, col, index)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, boolean[][] visited, 
                          String word, int row, int col, int index) {
        if (index == word.length()) return true;
        if (!isInBoundsAndNotVisited(board, row, col, visited) 
           || word.charAt(index) != board[row][col]) return false;
        visited[row][col] = true;
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {   // Four directions
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (exist(board, visited, word, newRow, newCol, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
    
    // Helper method to determine is a cell is in bounds and not already visited
    private boolean isInBoundsAndNotVisited(char[][] board, int row, int col, boolean[][] visited) {
        return col >= 0 && col < board[0].length 
            && row >= 0 && row < board.length
            && !visited[row][col];
    }
}