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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        // 方向标记 true 从左向右 false 从右向左
        boolean flag = false;

        List<Integer> valOrder = new LinkedList<>();
        valOrder.add(root.val);
        List<TreeNode> preNodeOrder = new LinkedList<>();
        preNodeOrder.add(root);

        while(preNodeOrder.size() != 0) {
            ret.add(valOrder);
            valOrder = new LinkedList<>();
            List<TreeNode> nodeOrder = new LinkedList<>();

            if (flag) {
                for (TreeNode node: preNodeOrder) {
                    if (node.left != null) {
                        valOrder.add(node.left.val);
                        nodeOrder.add(node.left);
                    }
                    if (node.right != null) {
                        valOrder.add(node.right.val);
                        nodeOrder.add(node.right);
                    }
                }
            } else {
                for (TreeNode node: preNodeOrder) {
                    if (node.right != null) {
                        valOrder.add(node.right.val);
                        nodeOrder.add(node.right);
                    }
                    if (node.left != null) {
                        valOrder.add(node.left.val);
                        nodeOrder.add(node.left);
                    }
                }
            }

            flag = !flag;
            Collections.reverse(nodeOrder);
            preNodeOrder = nodeOrder;
        }

        return ret;
    }
}