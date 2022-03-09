class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        int count=0;
        int expenditure =0;
        for (int ele: costs){
            expenditure +=ele;
            if (expenditure <=coins){
                count++;
            }
            else
                break;
        }
        return count;
    }
};