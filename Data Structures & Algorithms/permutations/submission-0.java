class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    void backtrack(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, cur, res);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
}
