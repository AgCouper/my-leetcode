class Solution {
    /*
        Given a string s, reverse the string according to the following rules:
        - All the characters that are not English letters remain in the same position.
        - All the English letters (lowercase or uppercase) should be reversed.

        - s consists of characters with ASCII values in the range [33, 122].
        - s does not contain '\"' or '\\'.
     */
    public String reverseOnlyLetters(String s) {
        char chars[] = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (!Character.isLetter(chars[l])) {
                l++;
                continue;
            }

            if (!Character.isLetter(chars[r])) {
                r--;
                continue;
            }

            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;     
        }

        return new String(chars);
    }
}