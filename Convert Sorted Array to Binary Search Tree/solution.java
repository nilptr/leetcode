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
    // 转化为平衡 (高度差不大于1)
    // 二叉搜索树 (左子树上的所有节点小于根节点 右子树上的所有节点大于根节点)
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) list.add(i);
        return sortedArrayToBST(list);
    }

    private TreeNode sortedArrayToBST(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return null;
        if (nums.size() == 1) return new TreeNode(nums.get(0));

        int mid = nums.size() / 2;

        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums.subList(0, mid));
        root.right = sortedArrayToBST(nums.subList(mid + 1, nums.size()));

        return root;
    }
}
