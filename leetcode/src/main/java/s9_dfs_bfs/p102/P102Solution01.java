package s9_dfs_bfs.p102;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lennyz
 * @desc: 2020/11/18 8:08 AM
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 */
public class P102Solution01 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        bfs(lists, 0, root);
        return lists;
    }

    public void bfs(List<List<Integer>> res, int level, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        List<Integer> subRes = new ArrayList<>();
        if (res.size() == 0 || res.size() - 1 < level) {
            res.add(subRes);
        } else {
            subRes = res.get(level);
        }
        subRes.addAll(Arrays.asList(treeNode.val));
        bfs(res, level + 1, treeNode.left);
        bfs(res, level + 1, treeNode.right);
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