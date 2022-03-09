class Solution {
public:
    int countOnes(int num){
        int count = 0;
        while (num) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
    vector<int> countBits(int n) {
        vector<int> ans;
        for (int i=0;i<=n;i++){
            int count=0;
            ans.push_back(countOnes(i));
        }
        return ans;
    }
};