// 回文数字
//
// 判断是否为回文数 不能使用额外的空间
// => 毙掉转成字符串
// 不 reverse，逐位比较 避免溢出

class Solution {
public:
    bool isPalindrome(int x) {
        //! 根据定义 负数不能为回文数
        if (x < 0) return false;

        // 以下无视正负数
        int len = 1;
        int y = x;
        while ((y /= 10) != 0) len++;
        for (int i = 1; i <= len / 2; ++i) {
            int a = (x / int (pow(10, len - i))) % 10;
            int b = (x / int (pow(10, i - 1))) % 10;
            if (a != b) return false;
        }
        return true;
    }
};