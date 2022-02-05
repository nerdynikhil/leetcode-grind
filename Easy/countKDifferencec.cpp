//Bruteforce

class Solution {
public:
    int countKDifference(vector<int>& nums, int k) {
        int count=0;
        for (int i=0;i<nums.size();i++){
            for (int j=i+1;j<nums.size();j++)
                if (abs(nums[i]-nums[j])==k)
                    count++;
        }
        return count;
    }
};

//Using maps

class Solution {
public:
    int countKDifference(vector<int>& nums, int k) {
        int count=0;
        unordered_map<int, int> freq;
        
        for (int num: nums){
            count = count + freq[num+k] + freq[num-k];
            freq[num]++;
        }
        
        return count;
    }
};