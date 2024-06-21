class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0;
        for (int indx = 0; indx < n; indx++) {
            if (grumpy[indx] == 0) {
                ans += customers[indx];
                customers[indx] = 0;
            }
        }

        int left = 0, sum = 0, cnt = 0, res = 0;
        for (int right = 0; right < n; right++) {
            sum += customers[right];
            cnt++;
            if (cnt > minutes) {
                sum -= customers[left];
                left++;
                cnt--;
            }
            res = Math.max(res, sum);
        }
        return ans + res;
    }
}