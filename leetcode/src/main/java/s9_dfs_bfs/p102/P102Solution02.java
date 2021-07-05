package s9_dfs_bfs.p102;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class P102Solution02 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 模板
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int level = 0;
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                List<Integer> subRes = new ArrayList<>();
                if (res.size() == 0 || res.size() - 1 < level) {
                    res.add(subRes);
                } else {
                    subRes = res.get(level);
                }
                subRes.addAll(Arrays.asList(node.val));

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return res;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(JSON.toJSON(lists));

    }


}