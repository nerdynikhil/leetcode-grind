class Solution {
public:
    
    bool checkValidity(int i, int j, int m, int n){
        if (i<0 or j<0  or i>=m or j>=n)
            return false;
        return true;
    }
    
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        vector<vector<int>> ans(mat.size(),vector<int>(mat[0].size(), -1));
        queue<pair<int,int>>q;
        
        for(int i=0;i<mat.size();i++){
            for (int j=0;j<mat[0].size();j++){
                if (mat[i][j]==0){
                    q.push({i,j});
                    ans[i][j]=0;
                }
            }
        }
        
        int m = mat.size();
        int n = mat[0].size();
        
        while(!q.empty()){
            int i= q.front().first;
            int j= q.front().second;
            
            if ((checkValidity(i+1,j,m,n)) and ans[i+1][j]==-1){
                q.push({i+1, j});
                ans[i+1][j] = ans[i][j] +1;
            }
            if ((checkValidity(i-1,j,m,n)) and ans[i-1][j]==-1){
                q.push({i-1, j});
                ans[i-1][j] = ans[i][j] +1;
            }
            if ((checkValidity(i,j+1,m,n)) and ans[i][j+1]==-1){
                q.push({i, j+1});
                ans[i][j+1] = ans[i][j] +1;
            }
            if ((checkValidity(i,j-1,m,n)) and ans[i][j-1]==-1){
                q.push({i, j-1});
                ans[i][j-1] = ans[i][j] +1;
            }
            q.pop();
        }
        
        return ans;
    }
};