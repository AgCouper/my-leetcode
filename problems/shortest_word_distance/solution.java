/*
Given an array of strings wordsDict and two different strings that already exist in the array word1 
and word2, return the shortest distance between these two words in the list.
*/
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int w1Idx = -1, w2Idx = -1;
        int d = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if (w.equals(word1)) {
                w1Idx = i;
                if (w2Idx != -1) {
                    d = Math.min(d, i - w2Idx);
                }
            } else if (w.equals(word2)) {
                w2Idx = i;
                if (w1Idx != -1) {
                    d = Math.min(d, i - w1Idx);
                }
            }
        }

        return d;
    }
}