// 观察 [7, 10] 规律可得：拆分出尽量多的 3
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        return result * n;
    }
}
