class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxsum = nums[0]

        for i in range(len(nums)):
            cursum = 0
            for j in range(i, len(nums)):
                cursum += nums[j]
                maxsum = max(cursum, maxsum)
        return maxsum