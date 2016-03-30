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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> plist = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        getPath(root, path, plist);
        int maxDep = Integer.MIN_VALUE;
        for (int i = 0; i < plist.size(); ++i) {
            int dep = plist.get(i).size();
            if (dep > maxDep) maxDep = dep;
        }
        path = new ArrayList(maxDep);
        for (int i = 0; i < maxDep; ++i) {
            for (int j = 0; j < plist.size(); ++j) {
                if (i < plist.get(j).size()) {
                    path.add(plist.get(j).get(i));
                    break;
                }
            }
        }
        return path;
    }
    private void getPath(TreeNode root, List<Integer> pre, List<List<Integer>> plist) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            List<Integer> copy = new ArrayList<Integer>(pre.size() + 1);
            copy.addAll(pre);
            copy.add(root.val);
            plist.add(copy);
        }
        pre.add(root.val);
        getPath(root.right, pre, plist);
        getPath(root.left, pre, plist);
        pre.remove(pre.size() - 1);
    }
}

// 从右侧观察二叉树所得
// 遍历得到所有路径（右侧在前）