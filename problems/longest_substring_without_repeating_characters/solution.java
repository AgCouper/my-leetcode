/*
    Given a string s, find the length of the longest substring
    without repeating characters.

    Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            We use rolling window technique. On each iteration,
            w[c] == true for all the characters within the window.
            Because s consists of English letters, digits, symbols and spaces,
            we can use array instead of map.
        */
        boolean[] w = new boolean[256];
        Arrays.fill(w, false);

        int l = 0, r = 0, len = s.length(), maxLen = 0;
        if (len == 0) {
            return 0;
        }

        w[s.charAt(0)] = true;

        // invariant: s[l:r] has no dups
        while (true) {
            int dupIdx = growWindow(w, r, s);
            maxLen = Math.max(maxLen, dupIdx - l); 

            if (dupIdx == len) {
                break;
            }

            char dup = s.charAt(dupIdx);
            l = shrinkWindow(w, l, dup, s);
            r = dupIdx;
        }
        
        return maxLen;
    }

    /**
        Shrinks the window by moving left bound forward
        until there are no dups in the window.
    */
    public int shrinkWindow(boolean[] w, int l, char dup, String s) {
        while (s.charAt(l) != dup) {
            w[s.charAt(l)] = false;
            l++;
        }

        return l + 1;
    }

    /**
        Grows the window by moving right bound forward
        until there is a dup.
        Returns the position of a rightmost dup character.
    */
    public int growWindow(boolean[] w, int r, String s) {
        int res = s.length();
        for (int i = r + 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (w[ch] != false) {
                res = i;
                break;               
            } else {
                w[ch] = true;
            }
        }

        return res;
    }
}