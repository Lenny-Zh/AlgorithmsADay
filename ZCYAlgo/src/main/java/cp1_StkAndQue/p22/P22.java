package cp1_StkAndQue.p22;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/29 0029.
 * MaxTree定义如下:
 * 1. 数组必须没有重复元素
 * 2. MaxTree是一棵二叉树,数组的每一个值对应一个二叉树节点
 * 3. 包括MaxTree树在内且在其中的的每一棵子树上,值最大的节点都是树的头
 * 给一个数组arr,写一个数组转换MaxTree函数,数组长度为N
 * 要求: 时间复杂度为O(N),额外空间复杂度为O(N)
 *
 * 难度 : 校 ***
 *
 * 士: ( 1 - 4) 级
 * 尉: ( 5 - 8) 级
 * 校: ( 9 - 12 ) 级
 *
 */
public class P22 {

    @Test
    public void testP22(){


    }



    private void solutionV1(int[] arr){

        for (int i = 0; i < arr.length; i++) {


        }


    }

    class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }


}
