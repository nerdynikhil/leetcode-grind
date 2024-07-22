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
    private void rightSide(TreeNode root, int currentLevel, ArrayList<Integer> ans) {
        if (root == null)
            return;

        if (ans.size() == currentLevel) {
            ans.add(root.val);
        }

        rightSide(root.right, currentLevel + 1, ans);
        rightSide(root.left, currentLevel + 1, ans);

        return;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        rightSide(root, 0, ans);
        return ans;
    }
}