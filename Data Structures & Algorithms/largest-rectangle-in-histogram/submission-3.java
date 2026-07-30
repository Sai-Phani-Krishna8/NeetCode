class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        for(int i=0; i<=n; i++) {
            int curhei = (i==n) ? 0 : heights[i];

            while(!st.isEmpty() && curhei < heights[st.peek()]) {
                int hei = heights[st.pop()];

                int width = st.isEmpty() ? i : i-st.peek()-1;
                maxarea = Math.max(maxarea, hei*width);
            }
            st.push(i);
        }
        return maxarea;
    }
}