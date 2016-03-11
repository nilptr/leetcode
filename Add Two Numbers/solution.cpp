/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode(0);
        ListNode* current = head;
        
        int carry = 0;

        while (l1 != NULL || l2 != NULL || carry != 0) {
            current->next = new ListNode(0);
            current = current->next;

            int a = l1 != NULL ? l1->val : 0;
            int b = l2 != NULL ? l2->val : 0;
            
            int sum = a + b + carry;
            current->val = sum % 10;
            carry = sum / 10;

            if (l1 != NULL) l1 = l1->next;
            if (l2 != NULL) l2 = l2->next;
        }

        ListNode* start = start->next;
        delete head;
        return start;
    }
};