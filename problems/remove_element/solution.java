class Solution {
    public int removeElement(int[] nums, int val) {
        int insIdx = 0;
        for (int i = 0; i < nums.length; ++i) {
            int d = nums[i];
            if (d != val) {
                if (insIdx != i) {
                    nums[insIdx] = d;
                }

                insIdx++;
            }
        }

        return insIdx;
    }
}