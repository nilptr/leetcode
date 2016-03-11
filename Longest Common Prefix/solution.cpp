class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix("");
        int size = strs.size();
        if (size == 0) return "";
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0][i];
            for (int j = 0; j < size; ++j) {
                if (i >= strs[j].length() || strs[j][i] != c) return prefix;
            }
            prefix += c;
        }
        return prefix;
    }
};