public class Solution {
    public boolean isPowerOfThree(int n) {
        // int 型 n 最大为 3 ^ 19
        return (n > 0 && 1162261467 % n == 0);
    }

    // 数学方法 计算 log
}
