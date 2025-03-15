//APPROACH 1
//142. Linked List Cycle II
//Runtime 4 ms Beats 9.83% 
//Memory 45.10MB Beats 10.90% Time Complexity: O(n)
//Space Complexity: O(n)
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

//APPROACH 2
//0ms Beats 100.00% TIME COMPLEXITY: O(n)
//Memory 44.40 MB Beats 92.57% SPACE COMPLEXITY:O(1)

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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                break;
            }
        }
        if(fast==null || fast.next==null){
                return null;
        }
        ListNode curr=head;

        while(curr!=slow){
            curr=curr.next;
            slow=slow.next;
        }  
        return curr;
    }
}
