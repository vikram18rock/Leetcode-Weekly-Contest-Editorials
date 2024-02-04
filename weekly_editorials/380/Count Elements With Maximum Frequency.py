class Solution:
    def maxFrequencyElements(self, nums):
        hash = [0] * 101
        n = len(nums)
        
        for i in range(n):
            hash[nums[i]] += 1
        
        maxi = max(hash)
        ans = 0
        
        for i in range(101):
            if hash[i] == maxi:
                ans += hash[i]
        
        return ans

