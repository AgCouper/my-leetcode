class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fib_1 = 1, fib_2 = 0, fib = 0;
            for (int i = 2; i <= n; i++) {
                fib = fib_1 + fib_2;
                fib_2 = fib_1;
                fib_1 = fib;
            }

            return fib;
        }
    }
}