class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
 class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // If current node's value is within the range, add it to sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Recursively traverse left and right subtrees
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
public class Main{
    public static void main(String[] args) {
        RangeSumBST solution = new RangeSumBST();

        // Constructing example 1's tree
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);
        int low1 = 7;
        int high1 = 15;
        System.out.println(solution.rangeSumBST(root1, low1, high1)); // Output: 32

        // Constructing example 2's tree
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);
        int low2 = 6;
        int high2 = 10;
        System.out.println(solution.rangeSumBST(root2, low2, high2)); // Output: 23
    }
}
