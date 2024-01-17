class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        
        processBackspaces(s, sStack);
        processBackspaces(t, tStack);
        return sStack.equals(tStack);
    }
    
    private void processBackspaces(String input, Stack<Character> stack) {
        for (char c : input.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(c);
        }
    }
}