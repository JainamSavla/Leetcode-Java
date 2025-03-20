/*
// Definition for a Node in the circular linked list.
class Node {
    public int val;
    public Node next;

    // Default constructor
    public Node() {}

    // Constructor to initialize a node with a value
    public Node(int _val) {
        val = _val;
    }

    // Constructor to initialize a node with a value and next pointer
    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // Step 1: Create a new node with the given insertVal
        Node node = new Node(insertVal);

        // Step 2: Handle the case where the list is empty
        if (head == null) {
            // If the list is empty, make the new node point to itself (circular)
            node.next = node;
            return node; // Return the newly created single-node circular list
        }

        // Step 3: Initialize pointers to traverse the circular linked list
        Node prev = head, curr = head.next;

        // Step 4: Traverse the list to find the correct insertion point
        while (curr != head) { // Stop when we loop back to the starting node
            // Case 1: Insert in the correct sorted position between prev and curr
            if ((prev.val <= insertVal && insertVal <= curr.val)
                // Case 2: Insert at the wrap-around point (from largest to smallest)
                || (prev.val > curr.val && (insertVal >= prev.val || insertVal <= curr.val))) {
                break; // Found the correct position, exit the loop
            }

            // Move forward in the list
            prev = curr;
            curr = curr.next;
        }

        // Step 5: Insert the new node between prev and curr
        prev.next = node; // Link prev to the new node
        node.next = curr; // Link new node to curr, maintaining circular structure

        // Step 6: Return the original head (list structure remains intact)
        return head;
    }
}
