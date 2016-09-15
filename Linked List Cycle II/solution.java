public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        for (;;) {
            if (fast == null || fast.next == null) return null;
            if (fast == slow) {
                fast = head;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        for (;;) {
            if (fast == slow) return fast;
            slow = slow.next;
            fast = fast.next;
        }
    }
}
