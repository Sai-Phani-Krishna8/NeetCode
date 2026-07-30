class Solution {
    int index;

    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return solve(tokens);
    }

    private int solve(String[] tokens) {
        String token = tokens[index--];

        if (token.equals("+")) {
            int right = solve(tokens);
            int left = solve(tokens);
            return left + right;
        }
        else if (token.equals("-")) {
            int right = solve(tokens);
            int left = solve(tokens);
            return left - right;
        }
        else if (token.equals("*")) {
            int right = solve(tokens);
            int left = solve(tokens);
            return left * right;
        }
        else if (token.equals("/")) {
            int right = solve(tokens);
            int left = solve(tokens);
            return left / right;
        }
        else {
            return Integer.parseInt(token);
        }
    }
}