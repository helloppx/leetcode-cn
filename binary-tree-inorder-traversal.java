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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<Integer>();
        List<Integer> list = new LinkedList<>();
        process(list, root);
        return list;
    }
    
    public void process(List<Integer> list, TreeNode node){
        if(node != null){
            process(list, node.left);
            list.add(node.val);
            process(list, node.right);
        }
    }
}
