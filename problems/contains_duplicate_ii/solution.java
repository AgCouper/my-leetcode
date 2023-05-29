/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int idx = m.getOrDefault(v, - 1);
            if (idx == -1) {
                m.put(v, i);
            } else {
                if (i - idx <= k) {
                    return true;
                } else {
                    m.put(v, i);
                }
            }
        }

        return false;
    }
}