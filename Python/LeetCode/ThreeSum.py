'''
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

NOTE: The solution set must not contain duplicate triplets.

EXAMPLE:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

'''

class Solution(object):
    def threeSum(self, nums):
    # def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
            
        ans = set([])
        plus = sorted([n for n in nums if n>0])
        plus_c = set(plus)  #gets rid of duplicates
        zero = [n for n in nums if n == 0]
        minus = sorted([n for n in nums if n<0])
        minus_c = set(minus) #gets rid of duplicates
        # all zero
        if len(zero)>2:
            ans.add((0,0,0))
        # plus zero minus
        if len(zero)>0:
            for n in minus:
                if -n in plus_c:
                    ans.add((n,0,-n))
        # plus minus minus
        n = len(minus)
        for i in range(n):
            for j in range(i+1,n):
                diff = -(minus[i]+minus[j])
                if diff in plus_c:
                    ans.add((minus[i],minus[j],diff))
        # plus plus minus
        n = len(plus)
        for i in range(n):
            for j in range(i+1,n):
                diff = -(plus[i]+plus[j])
                if diff in minus_c:
                    ans.add((diff,plus[i],plus[j]))
        return list(ans)
