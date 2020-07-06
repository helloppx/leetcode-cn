/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int i = 0;
        int j = nums.length - 1;
        int mid = (j - i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, i, mid - 1);
        root.right = build(nums, mid + 1, j);
        return root;
    }

    private TreeNode build(int[] nums, int i, int j){
        if(i > j) return null;
        if(i == j) return new TreeNode(nums[i]);
        int mid = (j - i) / 2  + i;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, i, mid - 1);
        node.right = build(nums, mid + 1, j);
        return node;
    }
}
