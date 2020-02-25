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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        
        int count = 0;
        int nullCount = 0;
        int level = 2;
        boolean flag = true;
        List<Integer> tmp = new LinkedList<>();
        while (deque.size() != 0) {
            if(flag){
                TreeNode e = deque.pollFirst();
                tmp.add(e.val);
                if(e.left != null) {
                    deque.offerLast(e.left);
                    count++;
                }else{
                    nullCount++;
                }
                if(e.right != null) {
                    deque.offerLast(e.right);
                    count++;
                }else{
                    nullCount++;
                }
            }else{
                TreeNode e = deque.pollLast();
                 tmp.add(e.val);
                 if(e.right != null) {
                    deque.offerFirst(e.right);
                    count++;
                 }else{
                    nullCount++;
                 }
                 if(e.left != null) {
                    deque.offerFirst(e.left);
                     count++;
                 }else{
                     nullCount++;
                 }
            }
            if(nullCount + count >= level){
                res.add(tmp);
                tmp = new LinkedList<>();
                level = level << 1;
                nullCount = nullCount << 1;
                count = 0;
                flag = !flag;
            }
        }
        if(tmp.size() != 0){
            res.add(tmp);
        }
        return res;
    }
}
