class Solution {
public:
    string toLowerCase(string s) {
        for(char &ch : s){
            if (ch >= 'A' and ch <= 'Z')
                ch+=32;
        }
        return s;
    }
};