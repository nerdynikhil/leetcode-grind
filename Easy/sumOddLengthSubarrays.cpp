class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int sum=0;
		int n=arr.size();
		for (int i=0; i <n; i++)
		{
			for (int j=i; j<n; j++)
			{
				for (int k=i; k<=j; k++)
 
				{	
					if ((j-i+1)%2!=0)
					sum+=arr[k];
				}
			}
		}
		return sum;
    }
};