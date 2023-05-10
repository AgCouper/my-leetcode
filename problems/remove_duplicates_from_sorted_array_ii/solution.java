class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int insIdx = 1;
        int dupCount = 1;
        int dupNum = nums[0];

        // []
        // [1]
        // [1, 1]
        // [1, 1, 1, 2, 2, 3]
        for (int i = 1; i < nums.length; ++i) {
            int n = nums[i];
            if (n == dupNum) {
                if (dupCount < 2) {
                    nums[insIdx++] = n;
                    dupCount++;
                } 
            } else {
                dupCount = 1;
                dupNum = n;
                nums[insIdx++] = n;
            }
        } 

        return insIdx++;
    }
}