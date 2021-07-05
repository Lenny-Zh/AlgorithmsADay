package s4_tree.p94;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class P94Solution01 {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }

    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);

    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;


        System.out.println(inorderTraversal(root));
    }
}
