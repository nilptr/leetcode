public class Solution {
    // 0 - 8
    private static final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combination = new ArrayList<>(10);
        dfs(k, n, 0, combination, ret);
        return ret;
    }

    // deep-first-search
    private void dfs(int k, int n, int idx, List<Integer> combination, List<List<Integer>> results) {
        if (k == 0 && n == 0) {
            //! 避免使用相同引用
            results.add(new ArrayList<>(combination));
            return;
        }
        if (k > 9 - idx || idx > 8) return;
        dfs(k, n, idx + 1, combination, results);
        combination.add(nums[idx]);
        dfs(k - 1, n - nums[idx], idx + 1, combination, results);
        combination.remove(combination.size() - 1);
    }
}