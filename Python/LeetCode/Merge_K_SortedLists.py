'''
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

EXAMPLE:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from Queue import PriorityQueue

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = temp_node = ListNode(0)
        pq = PriorityQueue()  
        
        for list_node in lists:
            # if(list_node != None):
            if list_node:
                pq.put((list_node.val, list_node))
        while not pq.empty():
            value, node = pq.get()
            temp_node.next = ListNode(value)
            temp_node = temp_node.next
            node = node.next
            if(node != None):
                pq.put((node.val, node))
        return head.next

