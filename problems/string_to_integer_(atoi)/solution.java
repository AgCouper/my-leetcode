class Solution {
    public int myAtoi(String s) {
        // skip whitespaces
        int idx = 0;
        while (idx < s.length() && Character.isWhitespace(s.charAt(idx))) {
            idx++;
        }

        if (idx == s.length()) {
            return 0;
        }

        char c = s.charAt(idx);
        int neg = 1;
        if (c == '-' || c == '+') {
            idx++;
            if (c == '-') {
                neg = -1;
            }  
        }

        long res = 0;
        for (; idx < s.length(); ++idx) {
            int d = s.charAt(idx);
            if (d >= '0' && d <= '9') {
                res = res * 10 + neg * (d - '0');
            } else {
                break;
            }  

            if (res < Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            } else if (res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
            }
        }

        return (int)res;
    }
}