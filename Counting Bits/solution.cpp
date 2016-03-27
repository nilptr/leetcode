class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ret = { 0 };
        for (int i = 0; (1 << i) <= num; ++i) {
            int a = 1 << i;
            int b = 1 << (i + 1);
            for (int j = a; j < b; ++j) {
                if (j > num) break;
                ret.push_back(ret[j - a] + 1);
            }
        }
        return ret;
    }
};