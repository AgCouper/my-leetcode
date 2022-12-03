/*
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 */
class Solution {
    public int tribonacci(int n) {
    if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            int t3 = 0, t2 = 1, t1 = 1, fib = 0; 
            for (int i = 3; i <=n; i++) {
                fib = t3 + t2 + t1;
                t3 = t2;
                t2 = t1;
                t1 = fib;
            }

            return fib;
        }        
    }
}