public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] += prefixSum[i] + arr[i];
        }

        int res = 0, l = 0;
        for (int r = k - 1; r < arr.length; r++) {
            int sum = prefixSum[r + 1] - prefixSum[l];
            if (sum / k >= threshold) {
                res++;
            }
            l++;
        }
        return res;
    }
}