class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long l = 1;
        long r = x;
        while (r - l > 1) {
            long m = (l + r) / 2;
            long m2 = m * m;
            if (m2 == x) {
                return (int)m;
            } else if (m2 < x) {
                l = m;
            } else {
                r = m;
            }
        }

        return (int)l;
    }
}