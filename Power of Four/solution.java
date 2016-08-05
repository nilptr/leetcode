public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0
            && (num & num - 1) == 0    // 是 2 的幂 1000...
            && (num & 0x55555555) != 0; // 1 的位置在奇数位
    }
}