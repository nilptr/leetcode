// 找出数组中出现次数超过 [num.length / 3] 的元素
// 要求 时间复杂度 O(n) 空间复杂度 O(1)
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length;) {
            int count = 1;
            int num = nums[i];
            while(++i < nums.length && nums[i] == num) count++;
            if (count > nums.length / 3) ret.add(num);
            if (ret.size() == 2) break;
        }

        return ret;
    }
}