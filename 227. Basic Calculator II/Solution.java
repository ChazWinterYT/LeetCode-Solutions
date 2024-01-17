class Solution {
    Stack<Integer> stack = new Stack<>();
    String operator = "plus";
    int i = 0;
    
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        while (i < arr.length) {
            if (Character.isDigit(arr[i])) {
                // Check if it's a multi digit number
                StringBuilder sb = new StringBuilder();
                while (i < arr.length && Character.isDigit(arr[i])) {
                    sb.append(arr[i++]);
                }
                // move i back one spot when we see a non-digit
                i--;
                int currentNum = Integer.parseInt(sb.toString());
                operate(currentNum);
            } else if (arr[i] == '+') {
                operator = "plus";
            } else if (arr[i] == '-') {
                operator = "minus";
            } else if (arr[i] == '*') {
                operator = "times";
            } else if (arr[i] == '/') {
                operator = "divide";
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
    private void operate(int currentNum) {
        int previous = 0;
        switch (operator) {
            case "plus" :
                stack.push(currentNum);
                break;
            case "minus" :
                stack.push(-currentNum);
                break;
            case "times" :
                previous = stack.pop();
                stack.push(previous * currentNum);
                break;
            case "divide" :
                previous = stack.pop();
                stack.push(previous / currentNum);
                break;
        }
    }
}