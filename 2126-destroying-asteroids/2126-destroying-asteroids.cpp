class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        long long gatheredmass = mass;
        sort(asteroids.begin(), asteroids.end());
        for (int aster : asteroids){
            if (aster <= gatheredmass)
                gatheredmass += aster;
            else
                return false;
        }
        return true;
    }
};