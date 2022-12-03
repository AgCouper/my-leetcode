class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int steps1 = 2, steps2 = 1, steps = 0; 
            for (int i = 3; i <=n; i++) {
                steps = steps1 + steps2;
                steps2 = steps1;
                steps1 = steps;
            }

            return steps;
        }
    }
}