class Solution {
    /*
      You are given a large integer represented as an integer array digits, where each digits[i] 
      is the ith digit of the integer. The digits are ordered from most significant to least 
      significant in left-to-right order. The large integer does not contain any leading 0's.

      Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int idx = digits.length - 1;
        while (carry != 0 && idx >= 0) {
            int d = digits[idx] + carry;
            if (d > 9) {
                d = d - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            digits[idx] = d;
            idx--;
        }

        if (carry == 0) {
            return digits;
        }

        int arr[] = new int[digits.length + 1];
        arr[0] = 1;
        for (int i = 0; i < digits.length; ++i) {
            arr[i + 1] = digits[i];    
        }

        return arr;
    }
}