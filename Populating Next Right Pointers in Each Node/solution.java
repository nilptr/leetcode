/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode preLeft = root;
        TreeLinkNode curLeft = root.left;
        while (curLeft != null) {
            TreeLinkNode pre = preLeft;
            TreeLinkNode cur = curLeft;
            boolean isLeft = true;
            while (cur != null) {
                if (isLeft) {
                    cur.next = pre.right;
                    cur = cur.next;
                    pre = pre.next;
                } else {
                    if (pre == null) break;
                    cur.next = pre.left;
                    cur = cur.next;
                }
                isLeft = !isLeft;
            }
            preLeft = curLeft;
            curLeft = curLeft.left;
        }
    }
}