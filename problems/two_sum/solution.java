/*
 * Given an array of integers nums and an integer target, return indices of 
 * the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map from a number to its indices in the input array
        Map<Integer, List<Integer>> numsMap = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            numsMap.computeIfAbsent(n, k -> new ArrayList<>()).add(i);           
        }
        
        int res[] = new int[2];

        // for each unique number in the input array
        for (var e : numsMap.entrySet()) {
            // current number
            int val = e.getKey();

            // delta between the target and the current number
            int delta = target - val;

            // delta is the same as the current number, check if it occurs more than once in the array 
            if (delta == val) {
                List<Integer> indices = e.getValue();
                if (indices.size() > 1) {
                    // yes, so we got the result
                    return new int[] { indices.get(0), indices.get(1) };
                } else {
                    // nope, continue search
                    continue;
                }
            }
            
            // check if the delta value occurs in the array
            List<Integer> indices = numsMap.get(delta);
            if (indices != null) {
                //  yes, so we got the result
                return new int[] { indices.get(0), e.getValue().get(0) };
            }
        
        }
        
        return null;        
    }
}
