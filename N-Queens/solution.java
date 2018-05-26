class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        dfs(n, res, new ArrayList<Integer>(n));
        return res;
    }

    private void dfs(int n, List<List<String>> res, List<Integer> rows) {
        int len = rows.size();
        if (len == n) {
            List<String> board = new ArrayList(n);
            for (int i = 0; i < n; ++i) {
                board.add(rowStr(n, rows.get(i)));
            }
            res.add(board);
        }

        Set<Integer> disabled = new HashSet<Integer>();
        for (int i = 0; i < len; ++i) {
            int j = rows.get(i);
            disabled.add(j);
            disabled.add(j + (len - i));
            disabled.add(j - (len - i));
        }

        for (int i = 0; i < n; ++i) {
            if (!disabled.contains(i)) {
                rows.add(i);
                dfs(n, res, rows);
                rows.remove(len);
            }
        }
    }

    private String rowStr(int n, int q) {
        StringBuilder builder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            builder.append(i == q ? 'Q' : '.');
        }
        return builder.toString();
    }
}