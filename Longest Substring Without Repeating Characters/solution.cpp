class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len = s.size();

        // ascii hash
        bool exist[128];
        int max = 0;

        for (int k = 0; k < 128; ++k) exist[k] = false; 

        for (int i = 0; i < len; i++) {
            int j = i;
            for (j = i; j < len; ++j) {
                int pos = s[j];
                if (exist[pos]) {
                    break;
                } else {
                    exist[pos] = true;
                }
            }
            max = j - i > max ? j - i : max;
            for (int k = 0; k < 128; ++k) exist[k] = false;
        }

        return max;
    }
};