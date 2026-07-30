class MinStack {
    Stack<Integer> st;
    Stack<Integer> prefix;
    public MinStack() {
        st = new Stack<>();
        prefix = new Stack<>();
    }
    
    public void push(int val) {
        if(prefix.isEmpty()) {
            prefix.push(val);
        } else {
            if(prefix.peek() > val) prefix.push(val);
            else {
                Stack<Integer> temp = new Stack<>();
                while(!prefix.isEmpty() && prefix.peek() < val) {
                    temp.push(prefix.pop());
                }
                prefix.push(val);
                while(!temp.isEmpty()) {
                    prefix.push(temp.pop());
                }
            }
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.peek().equals(prefix.peek())) {
            prefix.pop();
        } else {
            Stack<Integer> temp = new Stack<>();
            while(!prefix.isEmpty() && prefix.peek() != st.peek()) {
                temp.push(prefix.pop());
            }
            if(!prefix.isEmpty()) prefix.pop();
            while(!temp.isEmpty()) {
                prefix.push(temp.pop());
            }
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return prefix.peek();
    }
}
