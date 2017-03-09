// 杨辉三角
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        // 直接模拟 公式计算 long 型会溢出
        List<Integer> prev = new ArrayList<>(1);
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 0; j < i - 1; ++j) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            if (i > 0) row.add(1);
            result.add(row);
            prev = row;
        }

        return result;
    }
}
