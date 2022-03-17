class Solution {
public:
    int getValue(char romanNumeral){
        switch(romanNumeral){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
    
    int romanToInt(string s) {
        int i;
        int n = s.size()-1;
        int ans=0;
        for(int i=n;i>=0;i--){
            if(getValue(s[i]) >= getValue(s[i+1])){
                ans+= getValue(s[i]);
            }
            else
                ans -= getValue(s[i]);
        }
        return ans;
    }
};