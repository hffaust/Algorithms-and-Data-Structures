class Solution(object):
    
    def expandAroundCenter(self, string, left_index, right_index):
        l = left_index
        r = right_index
        while(l >= 0 and r < len(string) and (string[l] == string[r])):
            l -= 1
            r += 1
            
        return (r - l - 1)
    
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        size = len(s)
        if(s == None or size < 1):
            return ""
        start = 0
        end = 0
        
        # s_rev = s[::-1]  #reversed string 
        
        for i in range(0, size):
            temp1 = Solution().expandAroundCenter(s, i , i)
            temp2 = Solution().expandAroundCenter(s, i, i+1)
            p_length = max(temp1, temp2)
            if(p_length > end - start):
                start = i - (p_length - 1) / 2
                end = i + p_length / 2
        return s[start:end+1]
            
            
    
