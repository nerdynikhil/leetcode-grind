class Solution {
    private int countOnes(int num) {
        if (num == 0) {
            return 0;
        }
        return (num & 1) + countOnes(num >> 1);
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }
}