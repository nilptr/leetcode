public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> set = new LinkedList<Integer>();
        dfs(nums, 0, set, ret);
        return ret;
    }
    // 避免重复元素
    private void dfs(int[] nums, int i, List<Integer> set, List<List<Integer>> ret){
        int len = nums.length;
        if (i == len) {
            List<Integer> copy = new ArrayList<Integer>(set.size());
            copy.addAll(set);
            ret.add(copy);
            return;
        }
        
        // 使用相同的当前元素
        set.add(nums[i]);
        dfs(nums, i + 1, set, ret);
        
        set.remove(set.size() - 1);
        // 直接跳过不用
        while(i + 1 < len && nums[i] == nums[i + 1]) i++;
        dfs(nums, i + 1, set, ret);
    }
}