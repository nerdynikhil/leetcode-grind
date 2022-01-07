class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set <int> set;
        for (auto ele: nums){
            if (set.find(ele) != set.end())
                return true;
            set.insert(ele);
        }
        return false;
    }
};