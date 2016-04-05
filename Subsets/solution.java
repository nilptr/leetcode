public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 每个集合元素顺序必须是非递减的
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> set = new LinkedList<Integer>();
        generate(nums, 0, set, ret);
        return ret;
    }
    private void generate(int[] nums, int i, List<Integer> set, List<List<Integer>> ret){
        int len = nums.length;
        if (i == len) {
            List<Integer> copy = new ArrayList<Integer>(set.size());
            copy.addAll(set);
            ret.add(copy);
            return;
        }
        generate(nums, i + 1, set, ret);
        set.add(nums[i]);
        generate(nums, i + 1, set, ret);
        set.remove(set.size() - 1);
    }
}