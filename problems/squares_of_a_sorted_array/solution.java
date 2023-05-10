class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length - 1;
        int idx = p2;

        while (p1 <= p2)  {
            int n1 = nums[p1];
            int n2 = nums[p2];

            if (Math.abs(n1) > Math.abs(n2)) {
                res[idx--] = n1 * n1;
                p1++;
            } else {
                res[idx--] = n2 * n2;
                p2--;
            }
        }

        return res;
    }
}