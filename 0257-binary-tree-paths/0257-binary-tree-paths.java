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
    void findPaths(TreeNode root, String currPath, List<String> ans) {

        if (root.left == null && root.right == null) {
            ans.add(currPath);
            return;
        }

        if (root.left != null) {
            findPaths(root.left, currPath + "->" + Integer.toString(root.left.val), ans);
        }

        if (root.right != null) {
            findPaths(root.right, currPath + "->" + Integer.toString(root.right.val), ans);
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        findPaths(root, "" + Integer.toString(root.val), ans);
        return ans;
    }
}