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
    static class Pair {
        TreeNode node;
        int val;
        Pair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public int goodNodes(TreeNode root) {
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, Integer.MIN_VALUE));

        while(!q.isEmpty()) {
            Pair it = q.poll();
            TreeNode node = it.node;
            int maxval = it.val;
            if(node.val >= maxval) {
                res++;
            }

            if(node.left != null) {
                q.offer(new Pair(node.left, Math.max(maxval, node.val)));
            }

            if(node.right != null) {
                q.offer(new Pair(node.right, Math.max(maxval, node.val)));
            }
        }

        return res;
    }
}
