/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();
        // only negative and zero numbers needs to be considered because
        // numbers > 0 can't add to zero
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            int n = nums[i];

            // find all pairs with sum equals to -n
            List<Pair> twoSumPairs = twoSum(-n, nums, i + 1);
            for (var p : twoSumPairs) {
                res.add(List.of(n, p.i1, p.i2));
            }

            // skip all the next occurrences of n
            for (; i < nums.length && nums[i] == n; i++) 
                ;
            i--;
        }

        return res;
    }

    private static class Pair {
        public final int i1;
        public final int i2;

        public Pair(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        public static Pair of(int i1, int i2) {
            return new Pair(i1, i2);
        }
    }

    /**
     * Starting from leftIdx, finds all pairs (n1, n2) where n1 + n2 == sum in the sorted array nums
     * The idea is the following:
     *  - Lets have two cursors, one moving from left to right and other moving from right to left 
     *  - Because the array is sorted, moving left cursor increases the sum, moving right cursor decreases the sum
     *  - So, if (n1 + n2) > sum, then move right cursor; if (n1 + n2) < sum, then move left cursor
     *  - Problem description states that the solution set must not contain duplicate triplets, so
     *    if (n1, n2) gives us the target sum, then move left/right cursor to a number different from n1/n2
     */
    private List<Pair> twoSum(int sum, int[] nums, int leftIdx) {
        List<Pair> res = new ArrayList();
        int rightIdx = nums.length - 1;
        while (leftIdx < rightIdx) {
            int nL = nums[leftIdx];
            int nR = nums[rightIdx];
            int nSum = nL + nR;

            if (nSum > sum) {
                rightIdx--;
                continue;
            } else if (nSum < sum) {
                leftIdx++;
                continue;
            } else {
                res.add(Pair.of(nL, nR));
                
                // move left cursor to a number different from nL
                for (; leftIdx < nums.length && nums[leftIdx] == nL; leftIdx++) 
                    ;
                
                // move right cursor to a number different from nL
                for (; rightIdx >= 0 && nums[rightIdx] == nR; rightIdx--)
                    ;
            }
        } 

        return res;
    }
}