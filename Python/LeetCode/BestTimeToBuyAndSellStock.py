class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)
        if(length <= 1):
            return 0
        
        max_profit = 0
        min_price = prices[0]
        
        for i in range(0, length):
            min_price = min(min_price, prices[i])
            max_profit = max(max_profit, prices[i] - min_price)
        return max_profit
    
