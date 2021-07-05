package trie.p212;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * <p>
 * 输入：
 * board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 */
public class P212Solution {

    /**
     * @Author ：lennyz
     * @Date: 2020/12/26 2:38 PM
     * @Desc:
     * 答案
     * 1. 首先用目标单词构建字典树
     * 2. DFS 遍历数组,查看所有结果, 如果结果在字典树中,那么表示匹配,返回结果
     *
     */

    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        wordTrie myTrie = new wordTrie();
        trieNode root = myTrie.root;
        for (String s : words)
            myTrie.insert(s);

        //使用set防止重复
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //遍历整个二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        System.out.print(result);
        return new LinkedList<String>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, trieNode cur) {
        //边界以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return;
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (cur == null) {
            //如果单词不匹配，回退
            visited[i][j] = false;
            return;
        }
        //找到单词加入
        if (cur.isLeaf) {
            result.add(cur.val);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
//            visited[i][j]=false;
//            return;
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }

    @Test
    public void test() {
//        char[][] board =
//                {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words =  {"oath","pea","eat","rain"};
//        findWords(board,words);
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};

        findWords(board, words);

    }


}

//字典树
class wordTrie {
    public trieNode root = new trieNode();

    public void insert(String s) {
        trieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new trieNode();
                cur = cur.child[c - 'a'];
            } else
                cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}

//字典树结点
class trieNode {
    public String val;
    public trieNode[] child = new trieNode[26];
    public boolean isLeaf = false;

    trieNode() {

    }
}

