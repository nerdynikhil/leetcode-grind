/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int height(TreeNode* root){
        if (root==NULL)
            return 0;
        else{
            return 1+ max(height(root->left), height(root->right));
        }
    }
    
    bool isBalanced(TreeNode* root) {
        if (root==NULL)
            return true;
        
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        
        return (abs(leftHeight-rightHeight)<2) and isBalanced(root->left) and isBalanced(root->right)?true:false;
    }
};