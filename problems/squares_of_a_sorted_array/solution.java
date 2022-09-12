class Solution {
    public int[] sortedSquares(int[] nums) {
        int posStart = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                posStart = i;
                break;
            }
        }

        int[] res = new int[nums.length];
        int negCursor = posStart - 1; // negative start
        int posCursor = posStart;     // positive start
        int resCursor = 0;

        while (negCursor >= 0 && posCursor < nums.length) {
            int negSquared = 0, posSquared = 0;

            negSquared = nums[negCursor] * nums[negCursor];
            posSquared = nums[posCursor] * nums[posCursor];

            if (negSquared < posSquared) {
                res[resCursor] = negSquared;
                negCursor--;
            } else  {
                res[resCursor] = posSquared;
                posCursor++;
            }

            resCursor++;
        }

        for (int i = negCursor; i>= 0; i--) {
            res[resCursor++] = nums[i] * nums[i];
        }

        for (int i = posCursor; i< nums.length; i++) {
            res[resCursor++] = nums[i] * nums[i];
        }

        return res;
    }
}