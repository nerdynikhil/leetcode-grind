class Solution {
public:
    int titleToNumber(string columnTitle) {
        int ans=0;
        for (auto &ch : columnTitle){
            ans *= 26;
            ans += ch- '@';
        }
        return ans;
    }
};