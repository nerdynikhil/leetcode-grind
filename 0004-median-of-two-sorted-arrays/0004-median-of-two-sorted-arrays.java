class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[nums1.length + nums2.length];
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        Arrays.sort(merged);

        double sum = 0;
        for (int ele : merged) {
            sum += ele;
        }

        int lengthOfMergedArr = merged.length;
        double median = 0;

        if (lengthOfMergedArr % 2 == 0) {
            median = (merged[lengthOfMergedArr / 2 - 1] + merged[lengthOfMergedArr / 2]) / 2.0;
        } else {
            median = merged[lengthOfMergedArr / 2];
        }

        return median;
    }
}