/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int leftLeavesSum(TreeNode root, Boolean isLeftLeaf) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return isLeftLeaf ? root.val : 0;

        int leftAns = leftLeavesSum(root.left, true);
        int rightAns = leftLeavesSum(root.right, false);

        return leftAns + rightAns;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeavesSum(root, false);
    }
}