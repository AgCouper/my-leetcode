/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.
*

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0, nums.length - 1, nums);        
    }

    // l = 0, r = 4, m = 2
    // l = 0, r = 1, m = 0
    TreeNode convert(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l)/2;
        var ln = convert(l, m - 1, nums);
        var rn = convert(m + 1, r, nums);

        return new TreeNode(nums[m], ln, rn);
    }
}