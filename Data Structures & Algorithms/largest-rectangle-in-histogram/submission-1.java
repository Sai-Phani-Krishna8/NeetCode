class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            left[i] = -1;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--) {
            right[i] = n;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                right[i] = st.peek();
            }
            st.push(i);
        }

        int maxarea = 0;
        for(int i=0; i<n;i++) {
            left[i] += 1;
            right[i] -= 1;

            maxarea = Math.max(maxarea, heights[i]*(right[i] - left[i] + 1));
        }
        return maxarea;
    }
}
