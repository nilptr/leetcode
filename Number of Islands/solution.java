public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 初次遇 1, 岛数 + 1, 将共同组成岛屿的区域标记为其他
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] != '1') return;
        // 深度搜索标记相邻陆地
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}