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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        inOrder(root, answer);
        return answer;
    }

    private void inOrder(TreeNode root, List<Integer> answer) {
        if (root == null)
            return;

        inOrder(root.left, answer);
        answer.add(root.val);
        inOrder(root.right, answer);
    }
}