//19. Remove Nth Node From End of List
//Runtime 0 ms Beats 100.00% Time COmplexity:O(n)
//Memory 41.85 MB Beats 44.28% Space Complexity:O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to head
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        
        // First pass to calculate the length of the list
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        // Calculate the position to stop at (just before the node to delete)
        int diff = len - n;
        ListNode temp = Dummy;
        
        // Move to the (len - n)th node
        for (int i = 0; i < diff; i++) {
            temp = temp.next;
        }
        
        // Delete the nth node from the end
        temp.next = temp.next.next;
        
        return Dummy.next;
    }
}

//Approach 2
//0 ms Beats 100.00% Time Complexity:O(n)
//Memory 41.85 MB Beats 44.28% Space Complexity:O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;

        ListNode curr = pHead;
        ListNode temp = pHead;

        
        for (int i = 0; i < n; i++) {
            if (curr == null) {
                return head; 
            }
            curr = curr.next;
        }

        // Move both pointers until curr reaches the end
        while (curr.next != null) {
            curr = curr.next;
            temp = temp.next;
        }

        // Remove the nth node from the end
        temp.next = temp.next.next;

        return pHead.next;
    }
}

