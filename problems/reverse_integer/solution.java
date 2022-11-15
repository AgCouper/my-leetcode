class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int d = x % 10;
            x = x / 10;

            try {
                res = Math.addExact(Math.multiplyExact(res, 10), d);                
            } catch (ArithmeticException e) {
                return 0;
            } 
        }
        
        return res;
    }
}