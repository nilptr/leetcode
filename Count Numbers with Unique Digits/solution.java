// 求 [0, 10 ^ n) 之间每位上不包含相同数字的个数
//  0 => [0, 1) => 1
//  1 => [0, 10) => 10
//  > 11 => 0
//
//  首位 [1, 9] 其余 m - 1 位由 9 个数字全排
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return 0;
        int result = 10;
        for (int i = 2; i <= n; ++i) {
            result += (9 * A(i - 1, 9));
        }
        return result;
    }

    private int A(int x, int y) {
        int result = 1;
        for (int i = 0; i < x; ++i) {
            result *= (y - i);
        }
        return result;
    }
}
