/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {val = x;}
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {return true;}
        if (node1 == null ^ node2 == null) {return false;}

        if (node1 != null && node2 != null && node1.val == node2.val) {
            return symmetric(node1.left, node2.right) &&
                   symmetric(node1.right, node2.left);
        }
        return false;

    }


}
