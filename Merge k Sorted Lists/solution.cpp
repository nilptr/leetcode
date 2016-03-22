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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* newList = NULL;
        for (int i = 0; i < lists.size(); ++i)
            newList = mergeTwoLists(newList, lists[i]);
        return newList;
    }
private:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        // ListNode * head = new ListNode();
        // ListNode * cur = head;
        ListNode head(-1); // 栈中，自动释放
        ListNode* cur = &head;

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

        // cur = head;
        // head = head->next;
        // delete cur;
        // return head;
        return head->next;
    }
};

// O(nk^2) 超时