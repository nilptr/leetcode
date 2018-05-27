class Solution {
    public int totalNQueens(int n) {
        int[] board = new int[n];

        int total = 0;

        for (int i = 0; i < n; ++i) {
            if (board[i] == n) { // 层级遍历完毕 向上回溯
                board[i] = 0;
                if (i > 0) {
                    board[i - 1]++;
                    i -= 2;
                    continue;
                } else { // 完成求解
                    return total;
                }
            }
            for (int j = board[i]; j < n; ++j) {
                // 判断当前放置位置是否合法
                boolean flag = false;
                for (int r = 0; r < i; ++r) {
                    if (conflict(r, board[r], i, j)) {
                        flag = true;
                        break;
                    }
                }


                if (flag) {
                    if (j == n - 1) { // 层级遍历完毕
                        board[i] = 0;
                        if (i - 1 >= 0) {
                            board[i - 1]++;
                            i -= 2;
                        }
                    }
                } else {
                    board[i] = j;
                    // 放置完毕
                    if (i == n - 1) {
                        total += 1;
                        board[i]++;
                        i--;
                    }
                    break;
                }
            }
        }

        return total;
    }

    private boolean conflict(int x1, int y1, int x2, int y2) {
        return y1 == y2 || y2 - y1 == x2 - x1 || y1 - y2 == x2 - x1 || x1 == x2;
    }
}