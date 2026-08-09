class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, res, new StringBuilder(), 0, 0);
        return res;
    }

    public void backtrack(int n, List<String> res, StringBuilder sb, int open, int close) {
        if(sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }

        if(open<n) {
            backtrack(n, res, sb.append("("), open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open) {
            backtrack(n, res, sb.append(")"), open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
