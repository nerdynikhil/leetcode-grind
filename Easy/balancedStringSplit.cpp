class Solution {
public:
    int balancedStringSplit(string s) {
        int l=0,r=0;
        int count=0;
        
        for(char ch:s){
            if(ch=='R') r++;
            else l++;
            
            if(r==l){
                count++;
                r=0;
                l=0;
            }
        }
        return count;
    }
};