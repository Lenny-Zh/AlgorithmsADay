package s4_tree.p145;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class P145Solution01 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 1. 暴力 多次遍历对比
     * 2.
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inorder(node.left, list);
        inorder(node.right, list);
        list.add(node.val);

    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;


        System.out.println(postorderTraversal(root));
    }
}
