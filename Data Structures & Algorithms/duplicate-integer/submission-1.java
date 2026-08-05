class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(hs.contains(nums[i])) {
                return true;
            }
            hs.add(nums[i]);
        }
        return false;
    }
}