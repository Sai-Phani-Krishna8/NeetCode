class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list, res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<=n; i++) {
            list.add(i);
            backtrack(i+1, n, k, list, res);
            list.remove(list.size()-1);
        }
    }
}