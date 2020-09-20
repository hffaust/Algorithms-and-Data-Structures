import java.util.*;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */


    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head_copy = new ListNode(0);
        ListNode l1_copy = l1, l2_copy = l2;
        ListNode current_node = head_copy;
        int carry_digit = 0;
        int x = 0, y = 0, sum = 0;
        while(l1_copy != null || l2_copy != null){

            if(l1_copy != null){
                x = l1_copy.val;
            }else{
                x = 0;
            }
            if(l2_copy != null){
                y = l2_copy.val;
            }else{
                y = 0;
            }
            sum = x + y + carry_digit;
            carry_digit = sum/10;
            current_node.next = new ListNode(sum % 10);
            current_node = current_node.next;
            if(l1_copy != null){
                l1_copy = l1_copy.next;
            }
            if(l2_copy != null){
                l2_copy = l2_copy.next;
            }
        }
        if(carry_digit > 0){
            current_node.next = new ListNode(carry_digit);
        }
        return head_copy.next;
        }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
