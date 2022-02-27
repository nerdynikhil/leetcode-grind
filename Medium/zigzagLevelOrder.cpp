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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        
        if (root == NULL)
            return {};
        
        int count=0;
        
        while (1){
            if (q.size()==0)
                return ans;
            
            vector<int> level;
            count++;
            
            int size = q.size();
            
            for (int i=0;i<size;i++){
                TreeNode* temp =q.front();
                level.push_back(temp->val);
                q.pop();

                if (temp->left!=NULL)
                    q.push(temp->left);

                if (temp->right!=NULL)
                    q.push(temp->right);
                
                
            }
            if (count%2==0)
                reverse(level.begin(), level.end());
            ans.push_back(level);
        }
        
        return ans;
    }
};