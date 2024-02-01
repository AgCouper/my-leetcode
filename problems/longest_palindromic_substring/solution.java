/*
    Given a string s, return the longest  palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
*/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        // m[l][r] - memoization, the longest palindrom when expanding from s[l:r] palindrom
        Pair[][] m = new Pair[len][len];

        Pair res = new Pair(0, 0);
        for (int i = 0; i < len; i++) {
            res = max(res, expand(m, s, i, i, s.charAt(i)));
        }

        return s.substring(res.l, res.r + 1);
    }

    /**
     * Example of input string: "babba"
     *
     * If we already have a palindrom, there are two ways we can try to make a bigger one out of it:
     *  - Add to it a character from the left and the same character from the right. 
     *    For example, if we have "bb" sub-palindrom from our example input string, 
     *    we can expand it by adding "a", resulting in a bigger subpalindrom "abba" 
     *  - Add to it a single character from the right. This handles the case when 
     *    a subpalindrom is composed from the same character repeated many times.
     *    For example, if we have "b" sub-palindrom from our example input string,
     *    we can expand it by adding "b" to the right, resulting in a bigger 
     *    subpalindrom "bb"
     */
    private static Pair expand(Pair[][] m, String s, int l, int r, Character sameChar) {
        // short circuit via memoization
        if (m[l][r] != null) {
            return m[l][r];
        }

        Pair res = new Pair(l, r);

        // try expand to the left and right
        if (l != 0 &&  r != s.length() - 1) {
            char ch1 = s.charAt(l - 1);
            char ch2 = s.charAt(r + 1);

            // can only expand palindrom if the left/right chars are the same
            if (ch1 == ch2) {
                res = max(expand(m, s, l - 1, r + 1, null), res);
            }
        }

        // can only expand to the right if all the characters within palindrom are the same
        if (sameChar != null && r != s.length() - 1) {
            char ch = s.charAt(r + 1);
            if (ch == sameChar) {
                res = max(expand(m, s, l, r + 1, sameChar), res);
            }
        }

        m[l][r] = res;
        m[r][l] = res;

        return res;
    }

    private static Pair max(Pair p1, Pair p2) {
        int l1 = p1.len();
        int l2 = p2.len();

        return l1 > l2? p1 : p2;
    }

    record Pair(int l, int r) {
        public int len() {
            return r - l;
        }
    };
}