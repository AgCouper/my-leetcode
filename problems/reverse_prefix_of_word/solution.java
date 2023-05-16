class Solution {
    /*
        Given a 0-indexed string 'word' and a character ch, reverse the segment of word 
        that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). 
        If the character ch does not exist in word, do nothing.    
     */
    public String reversePrefix(String word, char ch) {
        char chars[] = word.toCharArray();
        int idx = 0;
        for (; idx < chars.length && chars[idx] != ch; idx++)
            ;

        if (idx == chars.length) {
            return word;
        }

        int l = 0, r = idx;
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }

        return new String(chars);
    }
}