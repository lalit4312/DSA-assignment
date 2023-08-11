package Question4;

import Question4.BrothersBinaryTree;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BrotherBinaryTreeTest {
    @Test
    public void testAreBrothersPositive() {
        BrothersBinaryTree.TreeNode root = new BrothersBinaryTree.TreeNode(1);
        root.left = new BrothersBinaryTree.TreeNode(2);
        root.right = new BrothersBinaryTree.TreeNode(3);
        root.left.left = new BrothersBinaryTree.TreeNode(4);

        int x = 2;
        int y = 3;

        BrothersBinaryTree solution = new BrothersBinaryTree();
        boolean result = solution.areBrothers(root, x, y);
        assertTrue("Nodes " + x + " and " + y + " are expected to be brothers.", result);
    }

    @Test
    public void testAreBrothersNegative() {
        BrothersBinaryTree.TreeNode root = new BrothersBinaryTree.TreeNode(1);
        root.left = new BrothersBinaryTree.TreeNode(2);
        root.right = new BrothersBinaryTree.TreeNode(3);
        root.left.left = new BrothersBinaryTree.TreeNode(4);

        int x = 2;
        int y = 4;

        BrothersBinaryTree solution = new BrothersBinaryTree();
        boolean result = solution.areBrothers(root, x, y);
        assertFalse("Nodes " + x + " and " + y + " are not expected to be brothers.", result);
    }
}
