class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, count_w = 0, res = Integer.MAX_VALUE;
        for(int right=0; right<blocks.length(); right++) {
            if(blocks.charAt(right) == 'W') count_w++;

            if(right-left+1 == k) {
                res = Math.min(res, count_w);

                if(blocks.charAt(left) == 'W') count_w--;
                left++;
            }
        }
        return res;
    }
}