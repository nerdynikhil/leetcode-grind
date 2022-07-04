class Solution {
public:
    int candy(vector<int>& ratings) {
        int count=0;
        vector<int> distribution(ratings.size(), 1);
        
        for (int i=0;i<ratings.size()-1;i++){
            if (ratings[i+1]>ratings[i])
                distribution[i+1] = distribution[i]+1;
        }
        
        for (int i=ratings.size()-1;i>0;i--){
            
            if (ratings[i-1] > ratings[i]){
                if (distribution[i-1]<=distribution[i])
                distribution[i-1] = distribution[i]+1;
            }   
        }

        
        for (int i=0;i<ratings.size();i++){
            count+= distribution[i];
        }
        
        return count;        
    }
};