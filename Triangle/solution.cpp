class Solution {
public:
    int minimumTotal(vector< vector<int> >& triangle) {
        int size = triangle.size();

        // 初始化为 0
        int* pre = new int[size + 1]; // 上一层
        int* cur = new int[size + 1]; // 当前层结果
        for (int i = 0; i < size + 1; ++i)
            cur[i] = pre[i] = 0;

        for (int i = size - 1; i >= 0; --i) {
            int len = i + 1;
            for (int j = 0; j < len; ++j) {
                int tem = triangle[i][j];
                cur[j] = min(tem + pre[j], tem + pre[j + 1]);
            }
            int* tmp = cur;
            cur = pre;
            pre = tmp;
        }

        int min = pre[0];
        delete[] pre;
        delete[] cur;
        return min;
    }
};