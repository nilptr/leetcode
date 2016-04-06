public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>(k);
        dfs(n, k, 1, comb, ret);
        return ret;
    }
    public void dfs(int n, int k, int i, List<Integer> comb, List<List<Integer>> ret) {
        if (comb.size() == k) {
            List<Integer> copy = new ArrayList<Integer>(k);
            copy.addAll(comb);
            ret.add(copy);
            return;
        }
        if (i > n) return;
        dfs(n, k, i + 1, comb, ret);
        comb.add(i);
        dfs(n, k, i + 1, comb, ret);
        comb.remove(comb.size() - 1);
    }
}