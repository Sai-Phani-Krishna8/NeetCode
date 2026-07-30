class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : (path + "/").toCharArray()) {
            if(c == '/') {
                if(sb.toString().equals("..")) {
                    if(!st.isEmpty()) st.pop();
                } else if (!sb.toString().equals("") && !sb.toString().equals(".")) {
                    st.push(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        return "/" + String.join("/", st);
    }
}