/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        // the longest common prefix can't be longer than the shortest string 
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(strs[i].length(), minLen);
        }

        // just compare characters while they match
        boolean isStop = false;
        int prefixEnd = 0;
        for (; prefixEnd < minLen; prefixEnd++) {
            if (!isSameCharAtPos(strs, prefixEnd)) {
                break;
            }
        }

        return strs[0].substring(0, prefixEnd);
    }

    /**
     * Checks if all strings have the same chat at pos idx
     */
    private boolean isSameCharAtPos(String[] strs, int idx) {
        char c = strs[0].charAt(idx);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(idx) != c) {
                return false;
            }
        }

        return true;
    }
}