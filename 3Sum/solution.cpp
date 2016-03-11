class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ret;

        int size = nums.size();
        if (size < 3 || nums == NULL) return ret;

        // 排序
        vector<int> copy(nums);
        sort(copy.begin(), copy.end());

        for (int i = 0; i < size; ++i) {
            // skip same target
            if (i > 0 && copy[i - 1] == copy[i]) continue;
            
            int target = -copy[i];

            for (int j = i + 1, k = size - 1; j < k;) {
                if (copy[j] + copy[k] == target) {
                    vector<int> v(3);
                    v.push_back(copy[i]);
                    v.push_back(copy[j]);
                    v.push_back(copy[k]);
                    ret.push_back(v);
                    // skip same number
                    while(copy[j + 1] == copy[j]) j++;
                    while(copy[k - 1] == copy[k]) k--;
                    j++;
                    k--;
                } else if (copy[j] + copy[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ret;
    }
};