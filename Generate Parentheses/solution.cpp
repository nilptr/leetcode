class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        generate(ret, n, n, "");
        return ret;
    }
private:
    void generate(vector<string> &ret, int left, int right, string base) {
        if (left == 0 && right == 0) {
            ret.push_back(base);
            return;
        }

        if (left > 0) {
            generate(ret, left - 1, right, base + '(');
        }

        if (right > 0 && left < right) {
            generate(ret, left, right - 1, base + ')');
        }
    }
};