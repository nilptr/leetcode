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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> a = new Stack<>();
        Stack<TreeNode> b = new Stack<>();
        findPath(root, p, a);
        findPath(root, q, b);
        List<TreeNode> pa = toList(a);
        List<TreeNode> pb = toList(b);
        int i = 0;
        for (i = 0; i < pa.size() && i < pb.size(); ++i) {
            if (pa.get(i) != pb.get(i)) {
                break;
            }
        }
        return pa.get(i - 1);
    }
    private boolean findPath(TreeNode root, TreeNode child, Stack<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.push(root);
        if (root == child) {
            return true;
        }
        if (findPath(root.left, child, path) || findPath(root.right, child, path)) {
            return true;
        } else {
            path.pop();
            return false;
        }
    }
    private List<TreeNode> toList(Stack<TreeNode> stack) {
        List<TreeNode> list = new ArrayList<>(stack.size());
        for (TreeNode node: stack) {
            list.add(node);
        }
        return list;
    }
}
// -1 - 9999 单侧树 递归过深 StackOverflow
// but 为什么别人的解法就可以过... 自己本机测过不行...

// public class Solution {  
//     //2, 1  
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {  
//         if(root==null || p==null || q==null) return null;  
          
//         List<TreeNode> pathp = new ArrayList<>();  
//         List<TreeNode> pathq = new ArrayList<>();  
//         pathp.add(root);  
//         pathq.add(root);  
          
//         getPath(root, p, pathp);  
//         getPath(root, q, pathq);  
          
//         TreeNode lca = null;  
//         for(int i=0; i<pathp.size() && i<pathq.size(); i++) {  
//             if(pathp.get(i) == pathq.get(i)) lca = pathp.get(i);  
//             else break;  
//         }  
//         return lca;  
//     }  
      
//     private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {  
//         if(root==n) {  
//             return true;  
//         }  
          
//         if(root.left!=null) {  
//             path.add(root.left);  
//             if(getPath(root.left, n, path)) return true;  
//             path.remove(path.size()-1);  
//         }  
          
//         if(root.right!=null) {  
//             path.add(root.right);  
//             if(getPath(root.right, n, path)) return true;  
//             path.remove(path.size()-1);  
//         }  
          
//         return false;  
//     }  
// }