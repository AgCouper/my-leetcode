class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for (var acc : accounts) {
            int curSum = 0;
            for (int m : acc) {
                curSum += m;
            }
            
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
}