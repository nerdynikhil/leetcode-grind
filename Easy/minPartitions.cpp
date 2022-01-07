class Solution {
public:
    int minPartitions(string n) {
        int max_digit=0;
 
        for(int i=0;i<n.length();i++)
            max_digit=max(max_digit,(n[i]-'0'));
        
        return max_digit;
    }
};