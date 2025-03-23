//Runtime 0 ms Beats100.00% Time Complexity:O(N)
//Memory 41.48 MB Beats 93.95% Space Complexity: O(D)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

import java.util.Stack;

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node pHead = new Node();  // Dummy node
        Node prev = pHead;
        Stack<Node> stack = new Stack<>();
        stack.add(head);  // Correctly add head to stack

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            // Connect previous node to current
            prev.next = curr;
            curr.prev = prev;

            // If there's a next node, push it onto the stack
            if (curr.next != null) {
                stack.add(curr.next);
            }
         
            if (curr.child != null) {
                stack.add(curr.child);
                curr.child = null; 
            }

            // Move prev pointer forward
            prev = curr;
        }

        // Correct the actual head's prev pointer
        pHead.next.prev = null;

        return pHead.next;
    }
}
