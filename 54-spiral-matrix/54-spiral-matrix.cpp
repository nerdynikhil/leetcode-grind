class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        
        if (matrix.size()==0)
            return ans;
        
        int rowBegin=0;
        int rowEnd=matrix.size()-1;
        int colBegin=0;
        int colEnd=matrix[0].size()-1;
        
        while(rowBegin <= rowEnd and colBegin <=colEnd){
            //Move right
            for (int j=colBegin;j<=colEnd;j++){
                ans.push_back(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            //Move down
            for (int j=rowBegin;j<=rowEnd;j++){
                ans.push_back(matrix[j][colEnd]);
            }
            colEnd--;
            
            //Move left
            if (rowBegin<=rowEnd){
                for (int j=colEnd;j>=colBegin;j--){
                    ans.push_back(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            //Move up
            if (colBegin <= colEnd){
                for(int j=rowEnd;j>=rowBegin;j--){
                    ans.push_back(matrix[j][colBegin]);
                }
            }
            colBegin++;                     
        }
        return ans;   
    }
};