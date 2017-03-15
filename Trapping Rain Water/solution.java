public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len]; // 左侧高峰
        int[] right = new int[len]; // 右侧高峰
        for (int i = 1; i < len; ++i) {
            left[i] = height[i - 1] > left[i - 1]
                ? height[i - 1]
                : left[i - 1];
            right[len - i - 1] = height[len - i] > right[len - i]
                ? height[len - i]
                : right[len - i];
        }
        int total = 0;
        for (int i = 0; i < len; ++i) {
            int min = Math.min(left[i], right[i]); // 短板确定积水高度
            total += (min > height[i] ? min - height[i] : 0); // 注意和当前高度比较
        }
        return total;
    }
}
