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
        List<List<Integer>> result = new ArrayList<>();  
        if (root == null) {  
            return result;  
        }  
          
        LinkedList<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  
          
          
        boolean flag = true;  
        while (!queue.isEmpty()) {  
            ArrayList<Integer> list = new ArrayList<>();  
              
               
            if (flag) {  
                  
                TreeNode last = queue.getLast();  
                TreeNode node = null;  
                do {  
                    node = queue.getFirst();  
                    list.add(node.val);  
                      
                    if (node.left != null) {  
                        queue.addLast(node.left);  
                    }  
                    if (node.right != null) {  
                        queue.addLast(node.right);  
                    }  
                      
                    queue.removeFirst();  
                    if (queue.isEmpty()) {  
                        break;  
                    }  
                } while (node != last);  
                  
            } else {  
                TreeNode node = null;  
                TreeNode first = queue.getFirst();  
                do {  
                    node = queue.getLast();  
                    list.add(node.val);  
  
                    if (node.right != null) {  
                        queue.addFirst(node.right);  
                    }  
                    if (node.left != null) {  
                        queue.addFirst(node.left);  
                    }  
                      
  
                    queue.removeLast();  
                    if (queue.isEmpty()) {  
                        break;  
                    }  
                } while(node != first);  
            }  
              
            flag =  !flag;  
            result.add(list);  
        }  
          
        return result;  
    }
}