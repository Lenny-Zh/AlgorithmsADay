package s4_tree.p429;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 * <p>
 * 例如，给定一个 3叉树 :
 *
 * <p>
 [
 [1],
 [3,2,4],
 [5,6]
 ]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class P429Solution01 {

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
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        inorder(root, list,0);

        return list;
    }

    public void inorder(Node node, List<List<Integer>> list,int deep) {
        if (node == null) return;
        List<Integer> l ;
        if (list.size() - 1 < deep) {
            l = new ArrayList<>();
            list.add(l);
        } else {
            l = list.get(deep);
        }

        l.add(node.val);

        if (node.children != null) {
            for (Node n : node.children) {
                inorder(n, list, deep + 1);
            }
        }

    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);

        root.children = new ArrayList<>();
        root.children.add(left);
        root.children.add(right);

        System.out.println(levelOrder(root));
    }

}
