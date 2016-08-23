public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums.length == 0) return ret;
        if (nums.length == 1) {
            ret.add(Integer.toString(nums[0]));
            return ret;
        }
        int s = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == s) {
                    ret.add(Integer.toString(s));
                } else {
                    ret.add(Integer.toString(s) + "->" + Integer.toString(nums[i - 1]));
                }
                s = nums[i];
            }
        }
        if (nums[nums.length - 1] == s) {
            ret.add(Integer.toString(s));
        } else {
            ret.add(Integer.toString(s) + "->" + Integer.toString(nums[nums.length - 1]));
        }
        return ret;
    }
}
