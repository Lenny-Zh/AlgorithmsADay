package s9_dfs_bfs.p104;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author ：lennyz
 * @desc: 2020/11/18 8:08 AM
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。 *
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 */
public class P104Solution01_dfs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int dfs(TreeNode treeNode, int n) {
        if (treeNode == null) return n;
        return Math.max(dfs(treeNode.left,n+1), dfs(treeNode.right,n+1));
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(JSON.toJSON(maxDepth(root)));

    }


}