package s9_dfs_bfs.p101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class P101Solution01 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // bfs
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    list.add(node.left.val);
                    queue.add(node.left);
                }else {
                    list.add(1);
                }
                if(node.right != null) {
                    list.add(node.right.val);
                    queue.add(node.right);
                }else {
                    list.add(1);
                }
            }
            int total = list.size();
            if (total % 2 != 0) {
                return false;
            }
            for (int i = 0; i <= (total/2); i++) {
                int j = total-1 -i;
                if(list.get(i) != list.get(j)){
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }


}