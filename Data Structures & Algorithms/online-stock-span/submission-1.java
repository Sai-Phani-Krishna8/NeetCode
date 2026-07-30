class StockSpanner {
    Stack<int[]> st;
    int idx;
    public StockSpanner() {
        st = new Stack<>();
        idx = 0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && price >= st.peek()[0]) {
            st.pop();
        }
        int res = st.isEmpty() ? idx + 1 : idx - st.peek()[1];
        st.push(new int[]{price, idx++});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */