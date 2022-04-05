class Solution {
public:
    int maxArea(vector<int>& height) {
        int left=0;
        int right=height.size()-1;
        int mx=0;
        while(left<right)
        {
            mx=max(mx,(right-left)*min(height[right],height[left]));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return mx;
    }
};