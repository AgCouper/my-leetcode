/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
*/
class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList(); 
        if (nums.length == 0) {
            res.add(List.of(lower, upper));
            return res;
        }

        // "before range"
        int v0 = nums[0];
        if (lower != v0) {
            res.add(List.of(lower, v0 - 1));
        }

        // "in between" ranges
        for (int i = 1; i < nums.length; i++) {
            int vl = nums[i - 1];
            int vr = nums[i];
            if (vr - vl > 1) {
                res.add(List.of(vl + 1, vr - 1));
            }
        }

        // "after" range
        int vn = nums[nums.length - 1];
        if (vn != upper) {
            res.add(List.of(vn + 1, upper));
        }

        return res;
    }
}