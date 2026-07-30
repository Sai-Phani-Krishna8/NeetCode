class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i=0; i<height.length; i++) {
            while(!st.isEmpty() && height[i] >= height[st.peek()]) {
                int bottom = height[st.pop()];
                if(!st.isEmpty()) {
                    int rig = height[i];
                    int le = height[st.peek()];
                    int hei = Math.min(rig, le) - bottom;
                    int width = i-st.peek()-1;
                    res += hei*width;
                }
            }
            st.push(i);
        }
        return res;
    }
}
