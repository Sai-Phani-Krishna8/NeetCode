class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list, res);
        return res;
    }

    private void backtrack(int i, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if(i>n) {
            if(list.size() == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(i);
        backtrack(i+1, n, k, list, res);
        list.remove(list.size()-1);
        backtrack(i+1, n, k, list, res);
    }
}