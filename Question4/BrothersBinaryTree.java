package Question4;// 4.b)
// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
// return true if the nodes corresponding to the values x and y in the tree are brothers, or false otherwise.
// Two nodes of a binary tree are brothers if they have the same depth with different parents.
// Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false

public class BrothersBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int xDepth = -1; // Initialize depth of node x
    private int yDepth = -1; // Initialize depth of node y
    private TreeNode xParent = null; // Initialize parent of node x
    private TreeNode yParent = null; // Initialize parent of node y

    public boolean areBrothers(TreeNode root, int x, int y) {
        findNodes(root, null, 0, x, y); // Start searching for nodes x and y from root
        return xDepth == yDepth && xParent != yParent; // Check if they have the same depth and different parents
    }

    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) {
            return; // Base case: reached a null node
        }

        if (node.val == x) {
            xDepth = depth; // Update depth of node x
            xParent = parent; // Update parent of node x
        } else if (node.val == y) {
            yDepth = depth; // Update depth of node y
            yParent = parent; // Update parent of node y
        }

        findNodes(node.left, node, depth + 1, x, y); // Recurse on left subtree
        findNodes(node.right, node, depth + 1, x, y); // Recurse on right subtree
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int x = 4;
        int y = 3;

        BrothersBinaryTree solution = new BrothersBinaryTree();
        boolean result = solution.areBrothers(root, x, y);
        System.out.println("Nodes " + x + " and " + y + " are brothers: " + result);
    }
}
