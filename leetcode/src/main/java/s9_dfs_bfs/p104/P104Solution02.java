package s9_dfs_bfs.p104;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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
public class P104Solution02 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // bfs
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int n = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {

            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            n++;
        }
        return n;
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