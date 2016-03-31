public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        
        int[][] map = new int[m][n];
        map[m - 1][n - 1] = grid[m - 1][n - 1];
        
        for (int i = m - 2; i >= 0; --i) {
            map[i][n - 1] = grid[i][n - 1] + map[i + 1][n - 1];
        }
        
        for (int i = n - 2; i >= 0; --i) {
            map[m - 1][i] = grid[m - 1][i] + map[m - 1][i + 1];
        }
        
        for (int i = m - 2; i >= 0; --i)
            for (int j = n - 2; j >= 0; --j)
                map[i][j] = grid[i][j] + Math.min(map[i + 1][j], map[i][j + 1]);

        return map[0][0];
    }
}