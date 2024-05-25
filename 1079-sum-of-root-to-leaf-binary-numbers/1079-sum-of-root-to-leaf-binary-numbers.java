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
    void findSum(TreeNode root, String currPath, int[] ans) {

        if (root.left == null && root.right == null) {
            ans[0] += Integer.parseInt(currPath, 2);
            return;
        }

        if (root.left != null) {
            findSum(root.left, currPath + Integer.toString(root.left.val), ans);
        }

        if (root.right != null) {
            findSum(root.right, currPath + Integer.toString(root.right.val), ans);
        }

    }

    public int sumRootToLeaf(TreeNode root) {
        int[] ans = { 0 };
        findSum(root, "" + Integer.toString(root.val), ans);
        return ans[0];
    }
}