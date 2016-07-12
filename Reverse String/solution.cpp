class Solution {
public:
    string reverseString(string s) {
        int len = s.size();
        string ret = "";
        for (int i = 0; i < len; ++i) {
            ret.push_back(s[len - i - 1]);
        }
        return ret;
    }
};