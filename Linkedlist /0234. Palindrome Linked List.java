//Runtime 7 ms Beats 38.07%  time complexity :O(n)
//Memory 56.02 MB Beats 96.84% Space Complexity :O(n)
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode curr=head;

        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        int left=0,
            right=list.size()-1;
        while(left<right){
            if(list.get(left)!=list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}

//Approach 2
//3 ms Beats 99.75% Time Complexity: O(N)
//Memory 68.50 MB Beats 47.49% Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the list using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Compare the two halves
        ListNode left = head, right = prev;
        while (right != null) { // Only need to compare till right half ends
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
