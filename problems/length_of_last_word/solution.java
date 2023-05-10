class Solution {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        if (idx < 0) {
            return 0;
        }

        int worldEnd = idx;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
        }

        return worldEnd - idx;
    }
}