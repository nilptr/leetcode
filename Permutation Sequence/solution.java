public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).subList(0, n)
        );
        StringBuilder res = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            int a = factorial(n - i - 1);
            // 从 1 起始
            int idx = (k - 1) / a;
            // 取余恢复
            k = (k - 1) % a + 1;
            int digit = list.get(idx);
            list.remove(idx);
            res.append(Integer.toString(digit));
        }
        return res.toString();
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 0; i < n; ++i)
            res *= (n - i);
        return res;
    }
}
