class Solution {
    public int[] twoSum(int[] nums, int target) {
        // map from number to the 'last seen in the array' pos
        Map<Integer, Integer> m = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // if this number is in the array, we've got our solution
            int delta = target - n;
            int deltaPos = m.getOrDefault(delta, -1);
            if (deltaPos == -1) {
                // Haven't seen this number yet, but it might be further down the array.
                // In this case, when we encounter it, delta will be equal to the current n,
                // which we've just put into the map, so we'll get the solution. 
                m.put(n, i);
            } else {
                res[0] = i;
                res[1] = deltaPos;
                break;
            }
        }

        return res;
    }
}
