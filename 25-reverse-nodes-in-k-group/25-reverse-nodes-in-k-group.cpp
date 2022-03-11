/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    ListNode* reverse(ListNode* first, ListNode* last){
        ListNode *prev = NULL, *curr = first, *nextp;
        
        while (curr!=last){
            nextp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextp;
        }
        
        return prev;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        if(head==NULL or head->next==NULL or k==1){
            return head;
        }
        
        ListNode* node = head;
        
        for (int i=0;i<k;i++){
            if (node==NULL)
                return head;
            node = node->next;
        }
        
        ListNode* newHead= reverse(head, node);
        head->next = reverseKGroup(node, k);
        
        return newHead;
    }
};