class Solution {
    public int longestMonotonicSubarray(int[] a) {
        int m = 0;

        for (int i = 0; i < a.length; i++) {
            int c = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[j - 1]) {
                    c++;
                } else {
                    break;
                }
            }
            m = Math.max(m, c);
        }

        for (int i = 0; i < a.length; i++) {
            int c = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[j - 1]) {
                    c++;
                } else {
                    break;
                }
            }
            m = Math.max(m, c);
        }

        return m;
    }
}