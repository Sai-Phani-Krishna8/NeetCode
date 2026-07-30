class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int r=0; r<nums.length; r++) {
            
            //Remove indices that are outside window
            while (!dq.isEmpty() && dq.peekFirst() <= r - k) {
                dq.removeFirst();
            }

            //Remove indices that are less than current at last side
            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            //Add current indices to deque
            dq.addLast(r);


            if(r>=k-1) {
                res.add(nums[dq.peekFirst()]);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
