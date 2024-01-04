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
    public TreeNode searchBST(TreeNode root, int val) {
        //Recursive solution
        //O(logn) average, O(n) worst
        if(val == root.val) { //base case
            return root;
        }
        else if(val < root.val && root.left != null) {
            return searchBST(root.left, val);
        }
        else if(root.right != null) {
            return searchBST(root.right, val);
        }
        return null;
        
        /* 
        //Iterative solution
        //O(n) for n elements in stack
        Stack<TreeNode> tree = new Stack<>();
        
        tree.push(root);

        //O(n) for n elements in tree in worst case
        while(!tree.isEmpty()) {
            TreeNode temp = tree.pop();

            if(val == temp.val) {
                return temp;
            }
            else if(val < temp.val && temp.left != null) {
                tree.push(temp.left);
            }
            else if(temp.right != null) {
                tree.push(temp.right);
            }
        }

        return null; 
        */
    }
}