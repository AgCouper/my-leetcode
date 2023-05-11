/*
    Given a binary array nums and an integer k, return the maximum number 
    of consecutive 1's in the array if you can flip at most k 0's.
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        var st = new State();
        st.right = -1;

        // first, expand window from the first element
        expandWindow(nums, k, st);

        // then, shift window right one element and try to expand it further 
        while (st.right < nums.length - 1) {
            shiftWindow(nums, k, st);
            expandWindow(nums, k, st);
        }

        return st.right - st.left + 1;
    }

    public void shiftWindow(int[] nums, int k, State st) {
        st.curZeroes = st.curZeroes + nums[st.left] - nums[st.right + 1];
        st.left = st.left + 1;
        st.right = st.right + 1;
    }

    public void expandWindow(int[] nums, int k, State st) {
        int curZeroes = st.curZeroes;
        int right = st.right;
        for (int i = st.right + 1; i < nums.length; ++i) {
            int nextZeroes = curZeroes + 1 - nums[i];
            if (nextZeroes <= k) {
                right = i;
                curZeroes = nextZeroes;
            } else {
                break;
            }
        }

        st.curZeroes = curZeroes;
        st.right = right;
    }

    // represents window state
    private static class State {
        int left;
        int right;
        int curZeroes;
    }
}