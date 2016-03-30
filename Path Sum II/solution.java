/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;
        List<Integer> path = new LinkedList<Integer>();
        dfs(root, sum, path, ret);
        return ret;
    }
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            ret.add(path);
            return;
        }
        path.add(root.val);
        List<Integer> left = new LinkedList<Integer>();
        left.addAll(path);
        dfs(root.left, sum - root.val, left, ret);
        List<Integer> right = new LinkedList<Integer>();
        right.addAll(path);
        dfs(root.right, sum - root.val, right, ret);
    }
}