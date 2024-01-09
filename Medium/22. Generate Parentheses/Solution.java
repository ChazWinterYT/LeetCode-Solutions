class Solution {
    List<String> combinations = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return combinations;
    }
    
    private void backtrack(int open, int closed, int max, String current) {
        /* If we have all the parentheses, then that's a combination, so submit it. */
        if (current.length() == max * 2) {
            combinations.add(current);
            return;
        }
        
        /* If it is possible to add an open parenthesis, do so. */
        if (open < max) {
            backtrack(open + 1, closed, max, current + "(");
        }
        /* If it is legal to add a closed parenthesis, do so. */
        if (closed < open) {
            backtrack(open, closed + 1, max, current + ")");
        }
    }
}