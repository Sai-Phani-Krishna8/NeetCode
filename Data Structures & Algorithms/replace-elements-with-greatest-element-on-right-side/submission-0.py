class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans = [0] * n
        rightmax = -1

        for i in range(n-1, -1, -1):
            ans[i] = rightmax
            rightmax = max(arr[i], rightmax)
        return ans