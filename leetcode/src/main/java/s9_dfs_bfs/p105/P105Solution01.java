package s9_dfs_bfs.p105;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lennyz
 * @desc: 2020/11/18 8:08 AM
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class P105Solution01 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        List<TreeNode> treeNodes = new ArrayList<>();

//        dfsBuild(treeNodes, preorder, 0, true);

        return null;
    }


    public int dfsBuild(List<TreeNode> treeNodes, int[] preorder, int pIdx, int lIdx,boolean left) {
        TreeNode node = null;
        if (pIdx == 0) {
            node = new TreeNode(preorder[0]);
        }else {
            node = treeNodes.get(lIdx);


            if(pIdx < preorder.length){

            }


        }


//
//
//        dfsBuild(treeNodes, node, preorder, pIdx, lIdx++);
//
//
//        dfsBuild(treeNodes, preorder, 1, false);
        return 0;
    }

    public int dfsCheck(List<TreeNode> treeNodes, int[] inorder) {

        return 0;
    }

    @Test
    public void test() {
        int preorder[] = new int[]{3, 9, 20, 15, 7};
        int inorder[] = new int[]{9, 3, 15, 20, 7};

        System.out.println(JSON.toJSON(buildTree(preorder, inorder)));
    }


}