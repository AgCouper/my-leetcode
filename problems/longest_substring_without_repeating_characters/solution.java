class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] charPositions = new int[255];
        Arrays.fill(charPositions, -1);

        int maxLen = 0;
        int curLen = 0;
        for (int pos = 0; pos < s.length(); ++pos) {
            int charCode = s.charAt(pos);
            int charPos = charPositions[charCode];
            if (charPos == -1) {
                charPositions[charCode] = pos;
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 0;
                pos = charPos;
                Arrays.fill(charPositions, -1);
            }
        }

        maxLen = Math.max(maxLen, curLen);
        return maxLen;        
    }
}