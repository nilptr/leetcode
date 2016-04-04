public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (m == 0) return false;
        
        // 标记字符是否使用
        boolean[][] map = new boolean[m][n];
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (fuck(board, map, word, 0, i, j))
                    return true;
        
        return false;
    }

    // i => 当先匹配字符index
    // (x,y) => 当前位置
    private boolean fuck(char [][] board, boolean[][] map, String word, int i, int x, int y) {
        // 查找完成
        if (i == word.length()) return true;
        // 越界判断放在这里
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (m == 0) return false;
        if (x < 0 || x >= m || y < 0 ||y >= n) return false;
        // 当前字符不匹配
        if (word.charAt(i) != board[x][y] || map[x][y]) return false;
        // 标记
        map[x][y] = true;
        boolean result = fuck(board, map, word, i + 1, x + 1, y)
            || fuck(board, map, word, i + 1, x - 1, y)
            || fuck(board, map, word, i + 1, x, y + 1)
            || fuck(board, map, word, i + 1, x, y - 1);
        // 恢复
        map[x][y] = false;
        return result;
    }
}