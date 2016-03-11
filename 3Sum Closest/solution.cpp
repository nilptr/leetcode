class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.start(), nums.end());
        int len = nums.size();
        int closest = 0, d = INT_MAX;
        for (int i = 0; i < len; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1, k = len - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (sum - target < d) {
                        closest = sum;
                        d = sum - target;
                    }
                    k--;
                } else if (sum < target) {
                    if (target - sum < d) {
                        closest = sum;
                        d = target - sum;
                    }
                    j++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
};