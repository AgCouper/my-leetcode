class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsMap = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            numsMap.computeIfAbsent(n, k -> new ArrayList<>()).add(i);           
        }
        
        int res[] = new int[2];
        for (var e : numsMap.entrySet()) {
            int val = e.getKey();
            int delta = target - val;
            if (delta == val) {
                List<Integer> indices = e.getValue();
                if (indices.size() > 1) {
                    return new int[] { indices.get(0), indices.get(1) };
                } else {
                    continue;
                }
            }
            
            List<Integer> indices = numsMap.get(delta);
            if (indices != null) {
                return new int[] { indices.get(0), e.getValue().get(0) };
            }
        
        }
        
        return null;        
    }
}