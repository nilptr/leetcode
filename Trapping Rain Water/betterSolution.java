public class Solution {
    // 双指针 时间 O(n) 空间 O(1)
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0; // 围不起
        int left = 0;
        int right = len - 1;
        int total = 0;
        // 将左右指针各移至两边第一个峰值处 两峰之外无法积水
        // 注意保证左指针小于右指针 left < right
        while (left < right && height[left] < height[left + 1]) ++left;
        while (left < right && height[right - 1] > height[right]) ++right;
        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            // 先走较小一边 ✔️
            if (leftVal < right) {
                while (left < right && height[++left] < leftVal) {
                    total += (leftVal - height[left]);
                }
            } else {
                while (left < right && height[--right] < rightVal) {
                    total += (rightVal - height[right]);
                }
            }
        }
        return total;
    }
}
