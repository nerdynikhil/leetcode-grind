class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int index=0,maxPro=0,minimum=INT_MAX;
        
        for(int i=0;i<prices.size();i++)
        { 
            minimum=min(minimum,prices[i]);
            maxPro=max(maxPro,prices[i]-minimum);
         
        }
        return maxPro;
    }
};