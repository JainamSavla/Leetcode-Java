//Runtime 0 ms Beats 100.00% Time Complexity:O(n)
//Memory 42.39 MB Beats 82.12% Space Complexity :O(1)
/*
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
    public ListNode reverseList(ListNode head) {
        //1 → 2 → 3 → 4 → 5 → NULL
        ListNode prev = null;
        ListNode curr = head;  // head is pointing to node with value 1
        
        while(curr!=null){
           ListNode temp = curr.next;  // temp = 2
           curr.next = prev;           // Reverse link: 1 → NULL
           prev = curr;                // Move prev to 1
           curr = temp;                // Move curr to 2
         }
        return prev;
    }
}
