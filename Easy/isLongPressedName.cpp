class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        int i=0,j=0;
        while (typed[j]!='\0'){
            if (name[i]==typed[j]){
                i++;
                j++;
            }
            else if(name[i]!=typed[j] and (j>0 and typed[j] == typed[j-1]))
                    j++;
            else
                break;
        }
        if (i== name.size() and j== typed.size())
            return true;
        else
            return false;
    }
};
