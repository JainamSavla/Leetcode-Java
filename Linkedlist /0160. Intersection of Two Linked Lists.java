//160. Intersection of Two Linked Lists

//APPROACH 1
//Runtime 582 ms Beats 5.43%
//Memory 49.20 MB Beats 15.47%
// time complexity is O(m × n)
//space complexity is O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      for (ListNode currA = headA; currA != null; currA = currA.next) {
            for (ListNode currB = headB; currB != null; currB = currB.next) {
                if (currA == currB) {
                    return currA;
                }
            }
        }
        return null;
    }
}

//APPROACH 2
/*

*/
