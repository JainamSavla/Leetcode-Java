//2ms Beats 65.40%  Time Complexity:O(n)
//Memory 45.34 MB Beats 29.75% space complexity: O(n)
class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode currNext = curr.next;
            int gcdVal = gcd(curr.val, currNext.val);
            ListNode node = new ListNode(gcdVal);
            node.next = currNext;
            curr.next = node;
            curr = currNext;  // Move to the next original node
        }
        return head; // Return the modified list
    }
}
