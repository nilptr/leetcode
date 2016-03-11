// atoi 实现
// 1. skip whitespace characters
// 2. an optional +/- sign
// 3. stop when met non-numerical character 
// 4. overflow INT_MIN/INT_MAX

class Solution {
public:
    int myAtoi(string str) {
        int ret = 0;
        int i = 0;
        int len = str.length();
        // skip whitespace characters
        for(i = 0; i < len && (str[i] == ' ' || str[i] == '\n' || str[i] == '\t'); ++i);
        
        bool neg_flag = false;
        if (i == len) {
            return 0;
        } else if (str[i] == '-') {
            neg_flag = true;
            i++;
        } else if (str[i] == '+') {
            i++;
        }
        
        for (; i < len; ++i) {
            int digit = ctoi(str[i]);
            if (digit == -1) return ret;
            if (neg_flag) {
                // 溢出判断
                if (ret < (INT_MIN + digit) / 10) {
                    return INT_MIN;
                } else {
                    ret = ret * 10 - digit;
                }
            } else {
                if (ret > (INT_MAX - digit) / 10) {
                    return INT_MAX;
                } else {
                    ret = ret * 10 + digit;
                }
            }
        }

        return ret;
    }
private:
    int ctoi(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return -1;
        }
    }
};