class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] res = new int[n][2];
        for(int i=0; i<n; i++) {
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }

        Arrays.sort(res, (a,b)->Integer.compare(a[0], b[0]));
        
        Stack<Double> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            double time = (double) (target - res[i][0]) / res[i][1];

            if(st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        }
        return st.size();
    }
}