class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        for (int polyLength = s.length(); polyLength >= 1; polyLength--) {
            for (int startPos = 0; startPos + polyLength - 1 < s.length(); startPos++) {
                int endPos = startPos + polyLength - 1;
                if (isPalindrome(s, startPos, endPos)) {
                    return s.substring(startPos, endPos + 1);
                }
            }
        }

        return null;
    }

    private boolean isPalindrome(String s, int startPos, int endPos) {
        for (int i = startPos, j = endPos; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}