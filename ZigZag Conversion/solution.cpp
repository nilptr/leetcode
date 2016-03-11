class Solution {
public:
    string convert(string s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows >= len) return s;
        string ret("");
        for (int i = 0; i < numRows; ++i) {
            int skip = 2 * numRows - 2;
            int back = 2 * i;
            if (i == 0 || i == numRows - 1) {
                for (int j = 0; i + j < len; j += skip)
                    ret += s[i + j];
            } else {
                ret += s[i];
                for (int j = 1; ; ++j) {
                    int b = i + j * skip;
                    int a = b - back;

                    if (a < len) ret += s[a];
                    else break;

                    if (b < len) ret += s[b];
                    else break;
                }
            }
        }
        return ret;
    }
};