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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //O(n) for stacks and arraylists
        Stack<TreeNode> tree1 = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        ArrayList<Integer> values1 = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();
        int size1 = 0;
        int size2 = 0;

        tree1.push(root1);
        tree2.push(root2);
        
        //DFS, O(n) for n nodes to iterate through
        while(!tree1.isEmpty()) {
            TreeNode temp1 = tree1.pop();

            //checking if child on right side, pushing if so
            if(temp1.right != null) {
                tree1.push(temp1.right);
            }

            //checking if child on left side, pushing if so
            if(temp1.left != null) {
                tree1.push(temp1.left);
            }

            //checking if childless, adding leaf to list if so
            if(temp1.left == null && temp1.right == null) {
                values1.add(temp1.val);
            }
        }

        //DFS, O(n) for n nodes to iterate through
        while(!tree2.isEmpty()) {
            TreeNode temp2 = tree2.pop();

            //checking if child on right side, pushing if so
            if(temp2.right != null) {
                tree2.push(temp2.right);
            }

            //checking if child on left side, pushing if so
            if(temp2.left != null) {
                tree2.push(temp2.left);
            }

            //checking if childless, adding leaf to list if so
            if(temp2.left == null && temp2.right == null) {
                values2.add(temp2.val);
            }
        }

        if(values1.size() != values2.size()) {
            return false;
        }

        //compare values of array
        if(!values1.equals(values2)) {
            return false;
        }

        return true;
    }
}