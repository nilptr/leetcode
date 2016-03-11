// 最长回文子串 maxLen = 1000 unique
#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length();
        if (len == 1) return s;
        
        int max = 0;
        int start = 0; // 起始
        
        for (int i = 0; i < len; ++i) {
            // 奇数回文
            int j = 0;
            for (j = 0; (i >= j && i + j < len); ++j) {
                if (s[i - j] == s[i + j]) continue;
                else break;
            }
            // 越界&终止 j+1
            j = j - 1 > 0 ? j - 1 : 0;
            if (2 * j + 1 > max) {
                max = 2 * j + 1;
                start = i - j;
            }
            // 偶数回文
            //! s[i] != s[i + 1]时 j = 0 此时不可取
            if (s[i] == s[i + 1]) {
                for (j = 1; (i >= j && i + j + 1 < len); ++j) {
                    if (s[i - j] == s[i + j + 1]) continue;
                    else break;
                }
                j = j - 1;
                if (2 * j + 2 > max) {
                    max = 2 * j + 2;
                    start = i - j;
                }
            }
        }
        
        return s.substr(start, max);
    }
};

int main(int argc, char const *argv[])
{
    Solution solution;
    printf("%s\n", solution.longestPalindrome("abb").c_str());
    return 0;
}