class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }
    
    public void push(int value) {
        if(minStack.isEmpty() || value <= minStack.peek()) minStack.push(value);
        s.push(value);
    }
    
    public void pop() {
        int val = s.pop();
        if(val == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */