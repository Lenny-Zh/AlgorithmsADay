package s9_dfs_bfs.p101;

import org.junit.Test;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 */
public class P101Solution02 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // dfs
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if(left.val != right.val) return false;

        if ((
                (left.left == null && right.right == null)
                        || (left.left != null && right.right != null && left.left.val == right.right.val)
        )
                && (
                (left.right == null && right.left == null)
                        || (left.right != null && right.left != null && left.right.val == right.left.val)
        )
        ) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
//        root.left.left = null;
//        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
//        root.right.left = null;
//        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root));

    }


}