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
    void preorderTraversal(TreeNode* root, vector<int> &v){
        if (root!=NULL){
            v.push_back(root->val);
            preorderTraversal(root->left, v);
            preorderTraversal(root->right, v);
        }else
            v.push_back(100000);
    }
    
    void inorderTraversal(TreeNode* root, vector<int> &v){
        if (root!=NULL){
            inorderTraversal(root->left, v);
            v.push_back(root->val);
            inorderTraversal(root->right, v);
        }else
            v.push_back(100000);
    }
    
    
    bool isSameTree(TreeNode* p, TreeNode* q) {
        vector<int> inp, inq, prep, preq;
        
        inorderTraversal(p, inp);
        inorderTraversal(q, inq);
        
        preorderTraversal(p, prep);
        preorderTraversal(q, preq);
        
        if (inp ==inq and prep == preq)
            return true;
        else
            return false;
    }
};