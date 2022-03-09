class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int index=0;
        for (int ele: nums){
            if (ele!=val){
                nums[index] = ele;
                index++;
            }
        }
        return index;
    }
};