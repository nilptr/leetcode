/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode * head = (struct ListNode *) malloc(sizeof(struct ListNode));
    struct ListNode * cur = head;

    while (l1 != NULL || l2 != NULL) {
        if (l1 == NULL) {
            cur->next = l2;
            l2 = NULL;
        } else if (l2 == NULL) {
            cur->next = l1;
            l1 = NULL;
        } else {
            if (l1->val < l2->val) {
                cur->next = l1;
                cur = cur->next;
                l1 = l1->next;
            } else {
                cur->next = l2;
                cur = cur->next;
                l2 = l2->next;
            }
        }
    }

    cur = head;
    head = head->next;
    free(cur);
    return head;
}