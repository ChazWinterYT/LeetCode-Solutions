class MinStack {
    Stack<Integer> actualStack;
    Stack<Integer> minStack;
    
    public MinStack() {
        actualStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        actualStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!minStack.isEmpty() && minStack.peek().equals(actualStack.pop())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return actualStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */