class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int firstPartLen = 0;
        int secondPartLen = 0;
        boolean hasZero = false;

//        int firstZeroIdx = findFirstZero();
//        if (firstZeroIdx == -1) {
//            return nums.size() - 1;
//        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == 1) {
                secondPartLen++;
            } else {
                int totalLen = firstPartLen + secondPartLen;
                maxLen = Math.max(maxLen, totalLen);
                firstPartLen = secondPartLen;
                secondPartLen = 0;
                hasZero = true;
            }
        }

        int totalLen = firstPartLen + secondPartLen;
        maxLen = Math.max(maxLen, totalLen);

        return hasZero? maxLen : nums.length - 1;
    }
}