/*
   Given an integer array nums, move all 0's to the end of it while maintaining 
   the relative order of the non-zero elements. 
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int insPos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (insPos != i) {
                    nums[insPos] = nums[i];
                }

                insPos++;
            }
        }

        for (int i = insPos; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}