class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, candidates, target, cur, res);
        return res;
    }

    public void backtrack(int idx, int[] cand, int target, List<Integer> cur, List<List<Integer>> res) {
        if(target <= 0) {
            if(target == 0) res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=idx; i<cand.length; i++) {
            if(i>idx && cand[i] == cand[i-1]) continue;

            cur.add(cand[i]);
            backtrack(i+1, cand, target-cand[i], cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
