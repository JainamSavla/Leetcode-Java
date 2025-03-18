//203. Remove Linked List Elements
//Runtime 1 ms Beats 94.27% Time Complexity:O(n)
//Memory 45.70 MB Beats 52.54% Space Complexity:O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode phead=new ListNode(0);
        phead.next=head;
        ListNode prev=phead,
                 curr=head;
        
        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
            }else{
                prev=curr;
            }
            curr=curr.next;
        }
        return phead.next;
    }
}
