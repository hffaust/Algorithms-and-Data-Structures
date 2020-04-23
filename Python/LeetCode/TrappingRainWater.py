class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height == None or height == []:
            return 0
        #print height  #test print
        answer = 0        
        
        size = len(height)
        left_max = [None] * size
        right_max = [None] * size

        left_max[0] = height[0]
        
        for l in range(1, size):
            left_max[l] = max(height[l], left_max[l-1])
        #print left_max  #test print
        right_max[size-1] = height[size-1]
        for r in range(size-2, -1, -1):  #size-2 --> start pos; -1 --> to but not including end pos; -1 --> change per loop;
            right_max[r] = max(height[r], right_max[r+1])
	#print right_max  #test print            
        for i in range(1, size):
            answer += min(left_max[i], right_max[i]) - height[i]
            
        return answer
