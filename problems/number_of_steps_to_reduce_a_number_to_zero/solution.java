class Solution {
    public int numberOfSteps(int num) {
        int numStep = 0;
        while (num != 0) {
            numStep++;
            if (num  % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
        }
        
        return numStep;
    }
}