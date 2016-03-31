public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;

        // map[i][j] obstacleGrid[i][j] 到 obstacleGrid[m - 1][n - 1] 的路径数
        // obstacleGrid[i][j] 为 1 此处无法走通 map[i][j] = 0;
        int[][] map = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            if (obstacleGrid[i][n - 1] == 1) break;
            else map[i][n - 1] = 1;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (obstacleGrid[m - 1][i] == 1) break;
            else map[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (obstacleGrid[i][j] == 0) {
                    map[i][j] = map[i + 1][j] + map[i][j + 1];
                }
            }
        }

        return map[0][0];
    }
}