/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;
public class ReverseLinkedList {


    // iterative solution
    // Time complexity : O(n)O(n)O(n). Assume that nnn is the list's length, the time complexity is O(n)O(n)O(n).
    // Space complexity : O(1)O(1)O(1).
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // recursive solution
    // Time complexity : O(n)O(n)O(n). Assume that nnn is the list's length, the time complexity is O(n)O(n)O(n).
    // Space complexity : O(n)O(n)O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to nnn levels deep.
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    // My solution
    public ListNode reverseList(ListNode head) {

        ListNode revlist = new ListNode(0);
        ListNode start = revlist;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ListNode head_copy = head;
        while(head_copy != null){
            temp.add(head_copy.val);
            head_copy = head_copy.next;
        }
        System.out.println(temp);

        int size = temp.size();

        for(int i = size-1; i >= 0; i--){
            ListNode n = new ListNode(temp.get(i));
            revlist.next = n;
            revlist = revlist.next;
        }
        return start.next;
    }
}
