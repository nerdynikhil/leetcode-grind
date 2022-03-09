class Solution {
public:
    string capitalizeTitle(string title) {
        string ans, temp;
        for (int i=0;i<title.size();i++){
            if (title[i]==' '){
                string ss;
                if (temp.size()<=2){
                    for (int j=0;j<temp.size();j++)
                        ss+=tolower(temp[j]);
                }
                else{
                    ss+=toupper(temp[0]);
                    for (int j=1;j<temp.size();j++){
                        ss+=tolower(temp[j]);
                    } 
                }
                temp="", ans+=ss, ans+=' ';                    
            }
            else
                temp+=title[i];
        }
        if (temp.size()<=2){
            for (int j=0;j<temp.size();j++){
                ans+=tolower(temp[j]);
            }
        }
        else{
            ans += toupper(temp[0]);
            for (int j=1;j<temp.size();j++){
                ans+=tolower(temp[j]);
            }
        }
        return ans;
    }
};