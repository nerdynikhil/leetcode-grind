class Solution {
public:
    int findNumberOfWords(string str){
        int count=1;
        for (char ch: str){
            if (ch==' ')
                count++;
        }
        return count;        
    }
    int mostWordsFound(vector<string>& sentences) {
        int maxm = 0;
        for (auto sentence: sentences){
            int currSentenceSize = findNumberOfWords(sentence);
            maxm = max(maxm,currSentenceSize);
        }
        return maxm;
    }
};