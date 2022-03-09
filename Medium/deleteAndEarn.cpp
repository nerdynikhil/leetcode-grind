class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
    
        vector<int> count(10001, 0);
        
        for (int num: nums){
            count[num] += num;
        }
        
        int inc = 0;
        int exc = 0;
        
        for (int i=0;i<10001;i++){
            int ni = exc+count[i];
            int ne = max(inc, exc);
                
            inc = ni;
            exc = ne;
        }
        return max(inc,exc);
    }
};