class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxf = 0;
        int maxlen = 0;

        while(right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(right)));
            while((right-left+1)-maxf > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}