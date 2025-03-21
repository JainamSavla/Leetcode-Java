//Runtime 0 ms Beats 100.00% Time Complexity: O(N)
//42.42 MB Beats 79.12% Space Complexity: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge case: if the list is empty or has only one node, return as is
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list and get the last node (tail)
        int size = 1; // Start from 1 because we count the head as well
        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        ListNode tail = curr; // The last node (tail)

        // Step 2: Optimize `k` (if `k >= size`, rotation repeats)
        k = k % size;
        if (k == 0) return head; // No rotation needed

        // Step 3: Find the new tail (at position `size - k - 1`)
        int step = size - k;
        ListNode newTail = head;
        for (int i = 1; i < step; i++) { // Move (step - 1) times
            newTail = newTail.next;
        }

        // Step 4: Update pointers to perform rotation
        ListNode newHead = newTail.next; // New head is after new tail
        newTail.next = null; // Break the link
        tail.next = head; // Connect old tail to old head

        return newHead; // Return the new head
    }
}
