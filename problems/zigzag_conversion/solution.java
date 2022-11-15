class Solution {
    public String convert(String s, int numRows) {
         if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int numCols = 0;
        int delta = 2 * numRows - 2;
        int sLengthAdjusted = s.length() - (numRows - 1);
        if (sLengthAdjusted % delta == 0) {
            numCols = sLengthAdjusted / delta + 1;
        } else {
            numCols = sLengthAdjusted / delta + 2;
        }

        StringBuilder sb = new StringBuilder();
        boolean isDone = false;
        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            int startIdx1 = rowNum;
            int startIdx2 = delta - rowNum;

            for (int colNum = 0; colNum < numCols; ++colNum) {
                int idx = startIdx1 + colNum * delta;
                if (idx < s.length()) {
                    sb.append(s.charAt(idx));
                }

                if (colNum != numCols - 1 && rowNum != 0 && rowNum != numRows - 1) {
                    idx = startIdx2 + colNum * delta;
                    if (idx < s.length()) {
                        sb.append(s.charAt(idx));
                    }
                }
            }
        }

        return sb.toString();       
    }
}