//328. Odd Even Linked List
//Runtime 0 ms Beats 100.00% Time Complexity:O(n)
//Memory 44.57 MB Beats 63.35% Space Complexity: O(1) 
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head,
                 even=head.next,
                 evenhead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
            return head;
    }
}
