class Solution {
    List<List<String>> results = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        // Use an int array (index = row, value = column) to represent the layout because 
        // 1) it doesn't break my brain, and 2) you can't put two queens in the same row anyway.
        int[] queens = new int[n];
        backtrack(0, queens);
        return results;
    }
    
    private void backtrack(int row, int[] queens) {
        // Base case: If we process all rows, generate a board and submit the list.
        if (row == queens.length) {
            results.add(generateBoard(queens));
            return;
        }
        
        // Inclusion case: In the current row, try a queen at the next available column.
        for (int col = 0; col < queens.length; col++) {
            queens[row] = col;
            if (!sameColumn(row, queens) && !isDiagonal(row, queens)) {
                backtrack(row + 1, queens);
            }
        }
        // Backtrack if no valid column is found (what goes here?!?!?!)
        
    }
    
    // Check if the queen we just added is in the same column as a previously placed queen.
    private boolean sameColumn(int row, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row]) {
                return true;
            }
        }
        return false;
    }
    
    // Check if the queen we just added is on the same diagonal as a previously placed 
    // queen (explained at the bottom of this class).
    private boolean isDiagonal(int row, int[] queens) {
        for (int i = 0; i < row; i++) {
            int diffIndices = row - i;
            int diffValues = Math.abs(queens[row] - queens[i]);
            if (diffIndices == diffValues) {
                return true;
            }
        }
        return false;
    }
    
    // Generate the board layout per the problem requirements, using the int array we created.
    private List<String> generateBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // [ 2, 0, 3, 1 ]
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                // Put a 'Q' at the index containing the Queen, or else put a '.'
                if (queens[row] == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
            sb.setLength(0);    // Faster than creating a new one every time.
        }
        return board;
    }
}

/*
    Diagonal examples
    0,1         0,3         0,7         0,0
    1,2         1,4         1,6         1,1
    2,3         2,5         2,5         2,2
    3,4         3,6         3,4         3,3
    Difference between indices is always == (Absolute) difference between values

*/




