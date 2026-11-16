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
    int preIndex = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    private TreeNode helper(int[] preorder, int startIdx, int endIdx){
        if(startIdx > endIdx) return null;
        int nextRoot = preorder[preIndex++];
        TreeNode node = new TreeNode(nextRoot);
        int idx = hm.get(nextRoot);
        node.left = helper(preorder, startIdx, idx - 1);
        node.right = helper(preorder, idx + 1, endIdx);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

}
