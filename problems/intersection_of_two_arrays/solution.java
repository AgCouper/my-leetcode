/*
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            int v1 = nums1[p1];
            int v2 = nums2[p2];

            if (v1 < v2) {
                p1++;
            } else if (v1 > v2) {
                p2++;
            } else {
                res.add(v1);
                while (p1 < nums1.length && p2 < nums2.length && nums1[p1] == v1 && nums2[p2] == v1) {
                    p1++;
                    p2++;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}