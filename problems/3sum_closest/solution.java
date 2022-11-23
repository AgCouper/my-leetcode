/**
 * Given an integer array nums of length n and an integer target, 
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 *
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = 0;
        int targetDelta = Integer.MAX_VALUE; // there is no MAX_VALUE in the input array

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = n + twoSumClosest(nums, target - n, i); 
            int delta = Math.abs(sum - target) ;
            if (delta < targetDelta) {
                targetDelta = delta;
                closestSum = sum; 
            }
        }

        return closestSum;
    }

    /**
     * Same algorithm as for searching for the exact sum, 
     * but with keeping track of the closest sum
     */
    private int twoSumClosest(int[] nums, int targetSum, int excludeIndex) {
        int leftPos = 0;
        int rightPos = nums.length - 1;

        int closestSum = 0;
        int targetDelta = Integer.MAX_VALUE; // there is no MAX_VALUE in the input array
        while (leftPos < rightPos) {
            if (leftPos == excludeIndex) {
                leftPos++;
                continue;
            }   

            if (rightPos == excludeIndex) {
                rightPos--;
                continue;
            }

            int sum = nums[leftPos] + nums[rightPos];
            int delta = Math.abs(sum - targetSum) ;
            if (delta < targetDelta) {
                targetDelta = delta;
                closestSum = sum; 
            }

            if (sum < targetSum) {
                leftPos++;
            } else if (sum > targetSum) {
                rightPos--;
            } else {
                break;
            }
        }

        return closestSum;
    }
}