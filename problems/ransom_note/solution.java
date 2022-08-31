class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqTbl = new int[123];
        
        int len = magazine.length();
        for (int i = 0; i < len; i++) {
            int idx = (int)magazine.charAt(i);
            freqTbl[idx]++;
        }
        
        len = ransomNote.length();
        for (int i = 0; i < len; i++) {
            int idx = (int)ransomNote.charAt(i);
            if (freqTbl[idx]-- == 0) {
               return false; 
            }
        }
        
        return true;
    }
}