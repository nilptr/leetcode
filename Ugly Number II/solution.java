public class Solution {
    public int nthUglyNumber(int n) {
        int[] results = new int[n];
        results[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; ++i) {
            int var2 = results[p2] * 2;
            int var3 = results[p3] * 3;
            int var5 = results[p5] * 5;
            int min = Math.min(var5, Math.min(var2, var3));
            if (min == var2) p2++;
            if (min == var3) p3++;
            if (min == var5) p5++;
            results[i] = min;
        }
        return results[n - 1];
    }
}
