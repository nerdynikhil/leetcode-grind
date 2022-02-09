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
    
    unordered_map<int, int> freq;
    
    void dfs(TreeNode* root){
        if(root == NULL)
            return;
        else 
            freq[root->val]++;
        dfs(root->left);
        dfs(root->right);
    }
    
    vector<int> findMode(TreeNode* root) {
        vector<int> ans;
        int maximum =-1;
        dfs(root);
        for (auto ele: freq){
            if (ele.second == maximum)
                ans.push_back(ele.first);
            else if(ele.second> maximum){
                maximum = ele.second;
                ans.clear();
                ans.push_back(ele.first);
            }
        }
        return ans;
    }
};