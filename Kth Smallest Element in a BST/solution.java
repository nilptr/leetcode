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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = tree2list(root);
        return arr.get(k - 1);
    }

    private List<Integer> tree2list(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        list.addAll(tree2list(root.left));
        list.add(root.val);
        list.addAll(tree2list(root.right));
        return list;
    }
}
