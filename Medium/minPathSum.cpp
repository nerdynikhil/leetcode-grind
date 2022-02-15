//Using recursion

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int ans= minpath(grid, n-1, m-1);
        return ans;
    }
    
    int minpath(vector<vector<int>>& grid, int row, int col){
        if (row<0 or col <0)
            return INT_MAX;
        
        if (row==0 and col ==0)
            return grid[row][col];
        
        int up = minpath(grid, row-1, col);
        int left = minpath(grid, row, col-1);
        
        return min(up, left) + grid[row][col];
    }
};

//Using Rec + DP

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(n,vector<int>(m, 0));
        int ans= minpath(grid, n-1, m-1, dp);
        return ans;
    }
    
    int minpath(vector<vector<int>>& grid, int row, int col, vector<vector<int>>& dp){
        if (row<0 or col <0)
            return INT_MAX;
        
        if (row==0 and col ==0)
            return grid[row][col];
        
        if (dp[row][col]!=0)
            return dp[row][col];
        
        int up = minpath(grid, row-1, col, dp);
        int left = minpath(grid, row, col-1, dp);
        
        dp[row][col] = min(up, left) + grid[row][col];
         
        return dp[row][col];
    }
};