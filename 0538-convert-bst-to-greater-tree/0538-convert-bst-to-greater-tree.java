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
    private int convert(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = convert(node.right, sum);
        sum += node.val;
        node.val = sum;
        sum = convert(node.left, sum);
        return sum;
    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        convert(root, sum);
        return root;
    }
}