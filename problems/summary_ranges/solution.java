/*
We are given a sorted unique integer array nums.

Our task is to return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
*/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int rangeEnd = -1, rangeStart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (rangeEnd == -1) {
                rangeStart = i;
                rangeEnd = i;
            } else {
                if (nums[i] == nums[rangeEnd] + 1) {
                    rangeEnd = i;
                    continue;
                } else {
                    closeRange(res, nums, rangeStart, rangeEnd);
                    rangeEnd = -1;
                    i = i - 1;
                }
            }
        }

        if (rangeEnd != -1) {
            closeRange(res, nums, rangeStart, nums.length - 1);
        }

        return res;
    }

    private static void closeRange(List<String> res, int nums[], int rangeStart, int rangeEnd) {
        if (rangeStart == rangeEnd) {
            res.add(nums[rangeStart] + "");
        } else {
            res.add(nums[rangeStart] + "->" + nums[rangeEnd]);
        }        
    }
}