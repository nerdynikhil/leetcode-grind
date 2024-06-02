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
    private void findLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            leaves.add(root.val);

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
        return;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);

        if (leaves1.equals(leaves2))
            return true;
        else
            return false;
    }
}