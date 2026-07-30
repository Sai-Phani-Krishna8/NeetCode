class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l=0, r=0;
        int longest = 0;

        while(r<s.length()) {
            while(freq[s.charAt(r)] > 0 && r<s.length()) {
                freq[(s.charAt(l++))]--;
            }

            freq[s.charAt(r)]++;
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
}
