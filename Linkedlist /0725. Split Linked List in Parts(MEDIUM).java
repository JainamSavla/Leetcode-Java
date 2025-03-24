//0 ms Beats 100.00% TIME COMPLEXITY:O(n)
//43.30 MB Beats 92.69% SPACE COMPLEXITY:O(k) ;k number of parts in which linked list is split
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];

        // Count the length of the list
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int splitSize = n / k;  // Minimum size of each part
        int remainSize = n % k; // Number of parts that need an extra node

        ListNode newCurr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            res[i] = newCurr;
            int size = splitSize;

            if (remainSize > 0) {
                size++;
                remainSize--;
            }

            for (int j = 0; j < size; j++) {
                if (newCurr != null) {
                    prev = newCurr;
                    newCurr = newCurr.next;
                }
            }

            if (prev != null) {
                prev.next = null; // Break the current part from the rest
            }
        }
        return res;
    }
}
