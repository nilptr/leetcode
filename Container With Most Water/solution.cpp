// 木板数组，取两个木板使之间容量最大

// Time Limit Exceeded
//
// class Solution {
// public:
//     int maxArea(vector<int>& height) {
//         int size = height.size();
//         int max = INT_MIN;
//         for (int i = 0; i < size; ++i) {
//             for (int j = i + 1; j < size; ++j) {
//                 int h = height[i] > height[j] ? height[i] : height[j];
//                 int w = j - i;
//                 int s = h * w;
//                 if (s > max) max = s;
//             }
//         }
//         return max;
//     }
// };

// 贪心策略
// i < j 结对
// 推进策略: 推进长板 一定减小
class Solution {
public:
    int maxArea(vector<int>& height) {
        int size = height.size();
        int max = INT_MIN;
        for (int i = 0, j = size - 1; i < j;) {
            if (height[i] > height[j]) {
                max = height[j] * (j - i) > max ? height[j] * (j - i) : max;
                j--;
            } else {
                max = height[i] * (j - i) > max ? height[i] * (j - i) : max;
                i++;
            }
        }
        return max;
    }
};