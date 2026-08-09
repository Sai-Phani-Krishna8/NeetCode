class Solution {

    public void backtrack(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, curr, res);

            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // boolean[] visited = new boolean[nums.length];
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        
        return res;
    }
}