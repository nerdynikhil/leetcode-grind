class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int maxm = 0, sum;
        for (vector account: accounts){
            sum=0;
            for (int bal: account){
                sum += bal;
            }
            maxm = max(maxm, sum);
        }
        return maxm;
    }
};