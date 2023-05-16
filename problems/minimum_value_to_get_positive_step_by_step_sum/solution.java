class Solution {
    public int minStartValue(int[] nums) {
        int nSum = 0;
        for (var n : nums) {
            nSum += n;
        }
   
        int startValue = 1; // must be positive (> 0)
        for (int i = nums.length - 1; i >= 0; --i) {
            int v = 1 - nSum;
            startValue = Math.max(startValue, v);
            nSum -= nums[i];
        }

        return startValue;       
    }
}