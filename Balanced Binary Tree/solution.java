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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isBalanced(root.left)
            && isBalanced(root.right)
            && (Math.abs(getDepth(root.left) - getDepth(root.right)) < 2);
    }
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}