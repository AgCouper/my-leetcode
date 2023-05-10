class Solution {
    public boolean isSubsequence(String s, String t) {
        int posT = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            posT = findChar(t, c, posT + 1);
            if (posT == -1) {
                return false;
            }
        }

        return true;
    }

    int findChar(String s, char c, int startPos) {
        for (int i = startPos; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }
}