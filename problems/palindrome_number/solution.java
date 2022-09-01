class Solution {
    public boolean isPalindrome(int x) {
        int digits[] = new int[10];
        int curPos = 0;
        
        if (x < 0) {
            return false;
        }
        
        if (x >= 0 && x <= 9) {
            return true;
        }
        
        while (x > 0) {
            digits[curPos++] = x % 10;
            x = x / 10;
        }
        
        for (int i = 0, j = curPos - 1; i < j; i++, j--) {
            if (digits[i] != digits[j]) {
                return false;
            }
        }
        
        return true;
    }
}