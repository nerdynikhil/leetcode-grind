class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        //bruteforce
        vector<int> ans;
        for (int i=0;i<nums.size();i++){
            for (int j=i+1;j<nums.size();j++){
                if (nums[i]+nums[j] == target){
                    ans.push_back(i); 
                    ans.push_back(j); 
                    break;
                }
                    
            }
            if (ans.size()==2)
                break;
        }
        return ans;
    }
};