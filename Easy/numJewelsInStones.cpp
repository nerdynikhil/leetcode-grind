class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        int count = 0;
        if (jewels.size() < 1 or stones.size() < 1) {
            return count;
        }
        for (int i = 0; i < jewels.size(); i++) {
            for (int j = 0; j < stones.size(); j++) {
                if (jewels[i] == stones[j]) {
                    count++;
                }
            }
        }
        return count;
    }
};