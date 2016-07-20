public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 1; i < nums.length; ++i) {
            while (i < nums.length && nums[i - 1] == nums[i])
                i++;
            if (i < nums.length) nums[++len] = nums[i];
        }
        return len + 1;
    }
}