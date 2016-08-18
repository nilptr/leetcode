public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a, b;
        for (a = 0, b = numbers.length - 1; a < b;) {
            int sum = numbers[a] + numbers[b];
            if (sum == target) {
                break;
            } else if (sum < target) {
                a++;
            } else {
                b--;
            }
        }
        return new int[]{a + 1, b + 1};
    }
}
