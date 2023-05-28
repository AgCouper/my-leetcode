/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;

        // insert from the end
        int insIdx = nums1.length - 1;

        while (idx1 >=0 && idx2 >=0) {
            int v1 = nums1[idx1];
            int v2 = nums2[idx2];

            if (v1 > v2) {
                nums1[insIdx] = v1;
                idx1--;
            } else {
                nums1[insIdx] = v2;
                idx2--;
            }

            insIdx--;
        }

        for (; idx2 >= 0; idx2--) {
            nums1[insIdx--] = nums2[idx2];
        }

        for (; idx1 >= 0; idx1--) {
            nums1[insIdx--] = nums1[idx1];
        }
    }
}