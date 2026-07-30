class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for(String c:tokens) {
            if(c.equals("+")) {
                int cur1 = st.pop();
                int cur2 = st.pop();
                st.push(cur2 + cur1);
            } else if(c.equals("*")) {
                int cur1 = st.pop();
                int cur2 = st.pop();
                st.push(cur2 * cur1);
            } else if(c.equals("-")) {
                int cur1 = st.pop();
                int cur2 = st.pop();
                st.push(cur2 - cur1);
            } else if(c.equals("/")) {
                int cur1 = st.pop();
                int cur2 = st.pop();
                st.push(cur2 / cur1);
            } else {
                st.push(Integer.parseInt(c));
            }
            
        }
        return st.pop();
    }
}
