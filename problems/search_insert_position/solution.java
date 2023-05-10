class Solution {
    public int searchInsert(int[] nums, int target) { 
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int d = nums[m];
            if (d == target) {
                return m;
            } else if (d < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
   }
}