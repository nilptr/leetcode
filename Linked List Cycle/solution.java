/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // 1步 2步 相遇有环，结尾无环
        ListNode a = head.next, b = head.next.next;
        while(true) {
            if (a == b) return true;
            if (a == null || b == null) return false;
            a = a.next;
            b = b.next;
            if (b == null) return false;
            b = b.next;
        }
    }
}