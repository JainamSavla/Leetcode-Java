//0ms Beats 100.00% Time Complexity: O(N+M)
//Memory 42.19 MB Beats 97.43% Memory Complexity:O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify handling the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Merge both lists in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // Move tail forward
        }

        // Attach the remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the merged list (skip dummy node)
        return dummy.next;
    }
}
