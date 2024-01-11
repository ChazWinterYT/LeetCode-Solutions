class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<String> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                stack.push(operate(token, stack));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private boolean isOperator(String token) {
        return token.equals("+")
            || token.equals("-")
            || token.equals("*")
            || token.equals("/");
    }
    
    private String operate(String operator, Stack<String> stack) {
        int secondNum = Integer.parseInt(stack.pop());
        int firstNum = Integer.parseInt(stack.pop());
        switch (operator) {
            case "+" :
                return Integer.toString(firstNum + secondNum);
            case "-" :
                return Integer.toString(firstNum - secondNum);
            case "*" :
                return Integer.toString(firstNum * secondNum);
            case "/" :
                return Integer.toString(firstNum / secondNum);
        }
        return "";
    }
}