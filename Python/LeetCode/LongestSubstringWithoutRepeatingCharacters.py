class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(s == ""):
            return 0
        strlen = len(s)
        visited = [-1] * 256 #number of ascii characters; -1 meaning not visited
        prev_index = 0
        current_len = 1
        max_len = 1
        
        visited[ord(s[0])] = 0
        
        for i in xrange(1, strlen):
            prev_index = visited[ord(s[i])] #get index of current character
            if prev_index == -1 or (i - current_len > prev_index):
                current_len += 1
            else: #current character has been already been seen 
                if current_len > max_len:
                    max_len = current_len
                    
                current_len = i - prev_index
                
            # update the index of current character 
            visited[ord(s[i])] = i
        if current_len > max_len:
            max_len = current_len
        return max_len
            
        
