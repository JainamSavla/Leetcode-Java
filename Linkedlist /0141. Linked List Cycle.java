//0141. Linked List Cycle
//Runtime 5ms Beats 9.11%
//Memory 44.63MB Beats 38.68%


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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode curr=head;
        while(curr!=null){
            if(set.contains(curr)){
                return true;
            }
            set.add(curr);
            curr=curr.next;
        }
        return false;
    }
}

//APPROACH 2
//FLoyd Hare and Tortoise Algorithm
//Runtime 0 ms Beats 100.00%
//Memory 44.64 MB Beats 38.68%
//Logic
/*
Slow Pointer (slow): Moves one step at a time.
Fast Pointer (fast): Moves two steps at a time.
List: 1 → 2 → 3 → 4 → 2 (cycle)

slow = 1, fast = 2
slow = 2, fast = 4
slow = 3, fast = 3 (they meet!) → returns true.

*/
//Time Complexity: 𝑂(𝑛)
//Space Complexity: O(1)
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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head,
                 fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                 return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
