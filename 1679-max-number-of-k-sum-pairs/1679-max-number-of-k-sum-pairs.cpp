class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        int count=0;
        for (int b:nums){
            int a = k-b;
            if(mp[a]>0){
                count += 1;
                mp[a] -= 1;
            }
            else{
                mp[b] += 1;
            }
        }
        return count;
    }
};