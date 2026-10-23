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
    static int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(rh - lh) > 1) return false;

        boolean lb = isBalanced(root.left);
        boolean rb = isBalanced(root.right);
        return lb && rb;
    }
}