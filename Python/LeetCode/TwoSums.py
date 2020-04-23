class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums)
        hash_table = {}
        for i in range(0, length):
            if(target-nums[i] in hash_table):
                return [hash_table[target-nums[i]], i]
            else:
                hash_table[nums[i]] = i
        return None
