public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // 每一步分别计算左侧乘积
        result[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // 保存右侧元素的乘积
        int right = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            right *= nums[i + 1];
            result[i] *= right; // 左右相乘
        }
        return result;
    }
}
