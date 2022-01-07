class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int currSum=0;
        int maxm = INT_MIN;
        for (int ele: nums){
            currSum = max(currSum+ ele, ele);
            maxm = max(currSum, maxm); 
        }
        return maxm;
    }
};