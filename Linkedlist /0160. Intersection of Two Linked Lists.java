//160. Intersection of Two Linked Lists

//APPROACH 1
//Runtime 582 ms Beats 5.43% TIME COMPLEXITY
//Memory 49.20 MB Beats 15.47%
// time complexity is O(m × n)
//space complexity is O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      for (ListNode currA = headA; currA != null; currA = currA.next) {
            for (ListNode currB = headB; currB != null; currB = currB.next) {
                if (currA == currB) {
                    return currA;
                }
            }
        }
        return null;
    }
}

//APPROACH 2
//Runtime 6ms Beats 22.26%
//Memory 48.18MB Beats 85.36%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       Set<ListNode> set=new HashSet<>();
       ListNode currA=headA,
                currB=headB;
        while(currA!=null){
           set.add(currA);
           currA=currA.next;
        }          
        while(currB!=null){
            if(set.contains(currB)){
                return currB;
            }
            currB=currB.next;
        }
        return null;
    }
}

//Approach 3
//Runtime 1 ms Beats 99.90%
//Memory 48.59 MB Beats 68.14%
//Time Complexity:	𝑂(𝑚+𝑛)
//Space Complexity:	O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA,
                 currB=headB;

        while(currA!=currB){
           currA=currA==null?headB:currA.next;
           currB=currB==null?headA:currB.next;
        }
        return currA;
    }
}

//APPROACH 4
//1 ms Beats 99.90%  Time Complexity: O(m+n)
//Memory 49.29 MB Beats 8.84% Space Complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;

        int lenA = 0, lenB = 0;
        
        // Calculate length of List A
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }

        // Calculate length of List B
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }

        // Calculate the difference in lengths
        int diff = Math.abs(lenA - lenB);

        // Reset pointers to the heads
/*
Why Align Pointers?

After alignment, both currA and currB will have the same number of nodes left to traverse.
This ensures that if there's an intersection, they will meet at the same node.
*/
        if (lenA > lenB) {
            currA = headA;
            for (int i = 0; i < diff; i++) {
                currA = currA.next;
            }
            currB = headB;
        } else {
            currB = headB;
            for (int i = 0; i < diff; i++) {
                currB = currB.next;
            }
            currA = headA;
        }

        // Move both pointers together until they meet
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        // Either the intersection node or null
        return currA;
    }
}
