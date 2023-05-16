class Solution {
    /*
        Given a string s, reverse the order of characters in each word within a sentence 
        while still preserving whitespace and initial word order.

        - s does not contain any leading or trailing spaces.
        - There is at least one word in s.
        - All the words in s are separated by a single space.
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(l, i - 1, chars);
                l = i + 1;
            }
        }

        reverse(l, chars.length - 1, chars);

        return new String(chars);
    }

    public void reverse(int l, int r, char[] chars) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }
}