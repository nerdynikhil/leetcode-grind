class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        vector<int> counts;
        for(vector<int> query:queries){
            int count = 0;
            for(vector<int> point: points){
                int x = (query[0] - point[0])*(query[0] - point[0]) ;
                int y =  (query[1] - point[1])*(query[1] - point[1]);
                int radiusSquare =  query[2]*query[2];
                if(x + y <= radiusSquare) count++;
            }
            counts.push_back(count);
        }
        return counts;
    }
};