public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        int pre = 0;
        int max = 0;
        for (int i = 0; i < len - 1; ++i) {
            max = Math.max(max, nums[i] + i);
            if (i == pre) {
                steps++;
                pre = max;
            }
        }
        return steps;
    }
}
