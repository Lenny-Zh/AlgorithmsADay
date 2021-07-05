package s4_tree.p107;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class P107Solution01 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    /**
     * 1. 暴力 多次遍历对比
     * 2.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        inorder(root, list, 0);

        return list;
    }

    public void inorder(Node node, List<List<Integer>> list, int deep) {
        if (node == null) return;

        List<Integer> l;
        if (list.size() - 1 < deep) {
            l = new ArrayList<>();
            list.add(new ArrayList<>());
        }

        l = list.get(deep-list.size());

        if (node.children != null) {
            for (Node n : node.children) {
                inorder(n, list, deep + 1);
            }
        }

        l.add(node.val);
    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);

        root.children = new ArrayList<>();
        root.children.add(left);
        root.children.add(right);

        System.out.println(levelOrderBottom(root));
    }

}
