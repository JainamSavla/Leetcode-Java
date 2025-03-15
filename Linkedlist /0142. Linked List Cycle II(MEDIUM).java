//142. Linked List Cycle II
//Runtime 4 ms Beats 9.83%
//Memory 45.10MB Beats 10.90%
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
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode curr=head;
        while(curr!=null)
        {
            if(set.contains(curr)){
                return curr;
            }
            set.add(curr);
            curr=curr.next;
        }
        return null;
    }
}
