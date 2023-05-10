class Solution {
    // []
    // [1]
    // [1, 1]
    // [1, 2]
    // [1, 2, 2, ]
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int insIdx = 1;
        int curNum = nums[0]; 
        for (int i = 1; i < nums.length; ++i) {
            int d = nums[i];
            if (d != curNum) {
                if (insIdx != i) {
                    nums[insIdx] = d;
                }

                insIdx++;
                curNum = d;
            }
        }

        return insIdx;    
    }
}