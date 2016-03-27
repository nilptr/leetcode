class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int size = coins.size();
        int* map = new int[amount + 1];

        for (int i = 1; i <= amount; ++i) {
            int min = INT_MAX;
            for (int j = 0; j < size; ++j) {
                if (i < coins[j]) {
                    continue;
                } else if (i == coins[j]) {
                    min = 1;
                    break;
                } else {
                    int num = map[i - coins[j]];
                    if (num == -1) continue;
                    else ++num;
                    if (min > num) {
                        min = num;
                    }
                }
            }
            map[i] = min == INT_MAX ? -1 : min;
        }
        int ret = map[amount];
        delete map;
        return ret;
    }
};