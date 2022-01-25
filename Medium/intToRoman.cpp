class Solution {
public:
    string intToRoman(int num) {
        string dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        string res= "";
        for (int i=0;num!=0;i++){
            while (num>= index[i]){
                res += dict[i];
                num -= index[i];
            }
        }
        return res;
    }
};