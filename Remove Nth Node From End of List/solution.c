/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* prev = head;
    struct ListNode* end = head; // 双指针 保持间隔n向前推进

    for (int i = 0; i < n; ++i)
        end = end->next;
        
    if (end == NULL) {
        struct ListNode* tem = head->next;
        free(head);
        return tem;
    }
    
    while (end->next != NULL) {
        prev = prev->next;
        end = end->next;
    }

    struct ListNode* node = prev->next;
    prev->next = node->next;
    free(node);

    return head;
}