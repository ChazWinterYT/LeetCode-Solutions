class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }
        
        return result.toString();
    }
}

/**
* original solution before I knew what a Stack was
*/
/**
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder(s);
        int pointer = 0;

        while (pointer < result.length()) {
            if (result.charAt(pointer) == '*') {
                result.deleteCharAt(pointer);
                result.deleteCharAt(pointer - 1);
                pointer--;
            } else {
                pointer++;
            }
        }
        return result.toString();
    }
*/