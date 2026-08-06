class Solution {
    private int sum = 0;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, nums, target, list, res);
        return res;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> list, List<List<Integer>> res) {
        if(idx == nums.length) {
            if(target == sum) res.add(new ArrayList<>(list));
            return;
        }

        if(sum >= target) {
            if(sum == target) res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        sum += nums[idx];
        backtrack(idx, nums, target, list, res);
        sum -= nums[idx];
        list.remove(list.size()-1);
        backtrack(idx+1, nums, target, list, res);
    }
}
