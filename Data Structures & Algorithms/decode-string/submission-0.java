class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != ']') {
                st.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder sub = new StringBuilder();
                while(!st.peek().equals("[")) {
                    sub.insert(0, st.pop());
                }
                st.pop();

                StringBuilder k = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    k.insert(0, st.pop());
                }
                int count = Integer.parseInt(k.toString());

                StringBuilder repeated = new StringBuilder();
                for(int cou=0; cou<count; cou++) {
                    repeated.insert(0, sub.toString());
                }
                String repeatedstr = repeated.toString();
                st.push(repeatedstr);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    }
}