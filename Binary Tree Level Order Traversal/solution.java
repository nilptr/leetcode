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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        List<TreeNode> lastLevelNodes = Collections.singletonList(root);
        ret.add(Collections.singletonList(root.val));

        while (true) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();

            for (TreeNode node : lastLevelNodes) {
                if (node.left != null) {
                    nodes.add(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                    list.add(node.right.val);
                }
            }

            if (list.size() == 0) return ret;

            lastLevelNodes = nodes;
            ret.add(list);
        }
    }
}
