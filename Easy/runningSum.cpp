class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        int sum=0;
        vector<int> ans;
        for (int ele: nums){
            sum+= ele;
            ans.push_back(sum);
        }
        return ans;
    }
};