/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return ans;
    }

    private void find(TreeNode node, int k) {
        if(node == null) {
            return;
        }

        find(node.left, k);
        count++;
        if(count == k) {
            ans = node.val;
            return;
        }
        find(node.right, k);
    }
}
