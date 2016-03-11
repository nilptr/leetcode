// 按位反转数字
// 123 => 321
// -123 => -321
//
// !!!: 按字符翻转 注意后缀0
// !!!: overflow ?

class Solution {
public:
    int reverse(int x) {
        bool neg_flag = x < 0;
        int ret = 0;
        int digit = 0;
        while (x != 0) {
            digit = x % 10;
            // 溢出判断
            if (neg_flag) {
                if ((INT_MIN - digit) / 10 > ret)return 0;
            } else {
                if ((INT_MAX - digit) / 10 < ret) return 0;
            }
            ret = 10 * ret + digit;
            x /= 10;
        }
        return ret;
    }
};