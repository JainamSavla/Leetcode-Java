//707.Design Linked List
//9 ms Beats 54.07% 
//Memory 45.58 MB Beats 69.02%

// Node class for the singly linked list
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
            if (current == null) {
                return -1;  // Additional safety check
            }
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Append a node of value val as the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);  
        }

        Node newNode = new Node(val);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
}
