//Runtime 0 ms Beats 100.00% Time Complexity: O(n)
//Memory 44.28 MB Beats 93.15% Space Complexity: O(n)


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        // Step 1: Copy nodes and store them in the map
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next); // Set next pointer
            newNode.random = map.get(curr.random); // Set random pointer
            curr = curr.next;
        }

        // Return the deep copied head node
        return map.get(head);
    }
}

//Runtime 0 ms Beats 100.00%   Time complexity:O(n) 
//Memory 44.49 MB Beats 68.61% Space complexity:O(1) 

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a copy of each node and insert it right after the original node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers to the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move two steps
        }

        // Step 3: Separate the copied list from the original list
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        curr = head;

        while (curr != null) {
            copyCurr.next = curr.next; // Copy node
            curr.next = curr.next.next; // Restore original node
            curr = curr.next; // Move to next original node
            copyCurr = copyCurr.next; // Move in copied list
        }

        return dummyHead.next; // Return head of copied list
    }
}

 
