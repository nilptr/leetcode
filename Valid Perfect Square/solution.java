// 判断 num 是否为完全平方数
public class Solution {
    public boolean isPerfectSquare(int num) {
        // 二分搜索范围 [1, (num + 1) / 2]
        int a = 1;
        int b = (num + 1) / 2; // 第一次避免溢出 num = 2147483647

        while (a < b) {
            int mid = (a + b) / 2;
            long s = mid * mid; // 中位数平方可能溢出
            if (s == num) {
                return true;
            } else if (s < num) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }

        return a == b && a * a == num;
    }
}
