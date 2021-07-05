package trie.p212;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import trie.WordTrie;

import java.util.ArrayList;
import java.util.HashSet;
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
public class P212Solution_ReWrite {

    /**
     * @Author ：lennyz
     * @Date: 2020/12/26 2:38 PM
     * @Desc: 答案
     * 1. 首先用目标单词构建字典树
     * 2. DFS 遍历数组,查看所有结果, 如果结果在字典树中,那么表示匹配,返回结果
     */

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0) return new ArrayList<>();

        WordTrie wordTrie = new WordTrie();
        for (String word : words) {
            wordTrie.insert(word);
        }

        Set<String> result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                System.out.println(JSON.toJSONString(visited));
                find(wordTrie, null, board, i, j, visited, result);
            }
        }
        System.out.println(result);
        return new ArrayList<>(result);
    }

    public void find(WordTrie wordTrie, trie.TrieNode trieNode, char[][] board, int i, int j, boolean[][] visited, Set<String> result) {
        if ( i == board.length || j == board[0].length || j < 0 || i < 0 || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        visited[i][j] = true;

        if (trieNode == null) {
            trieNode = wordTrie.root;
        }
        trie.TrieNode leaf = trieNode.child[c - 'a'];

        if (leaf == null) {
            visited[i][j] = false;
            return;
        }

        if (leaf.isLeaf) {
            result.add(leaf.val);
        }
        find(wordTrie, leaf, board, i + 1, j, visited, result);
        find(wordTrie, leaf, board, i, j + 1, visited, result);
        find(wordTrie, leaf, board, i - 1, j, visited, result);
        find(wordTrie, leaf, board, i, j - 1, visited, result);
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



