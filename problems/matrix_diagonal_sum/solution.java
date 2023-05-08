class Solution {
    /*
        Given a square matrix mat, return the sum of the matrix diagonals.

        Only include the sum of all the elements on the primary diagonal and all 
        the elements on the secondary diagonal that are not part of the primary diagonal.
     */
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for (int i = 0; i < mat.length; ++i) {
            int j = len - i - 1;
            sum = sum + mat[i][i];

            if (i != j) {
                sum = sum + mat[i][j];
            }
        }

        return sum;
    }
}