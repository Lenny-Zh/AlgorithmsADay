package s4_tree.p590;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
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
public class P590Solution01 {

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

    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }

    public void inorder(Node node, List<Integer> list) {
        if (node == null) return;

        if (node.children != null) {
            for (Node n : node.children) {
                inorder(n, list);
            }
        }
        list.add(node.val);

    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);

        root.children = new ArrayList<>();
        root.children.add(left);
        root.children.add(right);

        System.out.println(postorder(root));
    }
}
