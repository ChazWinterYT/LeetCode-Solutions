class Solution {
    public boolean isValid(String s) {
        //use a Stack to keep track of the chars in the string
        Stack<Character> stack = new Stack<>();
        //iterate through the chars of the string
        for (int i = 0; i < s.length(); i++) {
            //variable representing the current char, e
            char e = s.charAt(i);
            //let's determine what to do depending on what e is
            switch(e) {
                case '(':
                case '[':
                case '{':
                    //if it's an open char, just put it on the stack'
                    stack.push(e); break;
                case ')':
                case ']':
                case '}':
                    //if it's closed, we're gonna check if its open counterpart
                    //is on the stack. If it's not there (due to mismatch or because
                    //stack is empty), return false
                    //if it's there, pop it. Use helper method 'match' to check
                    if (stack.isEmpty()) return false;
                    if (match(e, stack.peek())) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        //Once we check every char, if the stack is empty, return true.
        return stack.isEmpty();
    }

    private boolean match(char e, char f) {
        //helper method to check if the current closed char, e, has an
        //open counterpart, f, currently on top of the stack
        if (e == ')' && f == '(') return true;
        if (e == ']' && f == '[') return true;
        if (e == '}' && f == '{') return true;
        return false;
    }
}