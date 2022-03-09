class Solution {
public:
    void reverseString(vector<char>& s) {
        int left=0;
        int right = s.size()-1; 
        while (left<right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
};

//Using recursion

class Solution {
public:
    void helper(vector<char>& s, int index){
        if (index>=s.size()/2)
            return;
        swap(s[index], s[s.size()-index-1]);
        helper(s, index+1);
    }
    void reverseString(vector<char>& s) {
        helper(s,0);
    }
};