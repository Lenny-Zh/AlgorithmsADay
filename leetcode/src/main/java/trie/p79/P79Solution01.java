package trie.p79;

import org.junit.Test;
import trie.TrieNode;
import trie.WordTrie;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class P79Solution01 {


    /**
     * @Author ：lennyz
     * @Date: 2020/12/26 2:38 PM
     * @Desc: 答案
     * 1. 首先用目标单词构建字典树
     * 2. DFS 遍历数组,查看所有结果, 如果结果在字典树中,那么表示匹配,返回结果
     */

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty() || board.length == 0) return false;

        WordTrieUpOrLow wordTrie = new WordTrieUpOrLow();
        wordTrie.insert(word);

        char first = word.toCharArray()[0];

        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != first){
                    continue;
                }
                boolean[][] visited = new boolean[board.length][board[0].length];
                find(wordTrie, null, board, i, j, visited, result);
            }
        }
        System.out.println(result);
        return !result.isEmpty();
    }

    public void find(WordTrieUpOrLow wordTrie, TrieNodeBIG trieNode, char[][] board, int i, int j, boolean[][] visited, Set<String> result) {
        if (i == board.length || j == board[0].length || j < 0 || i < 0 || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        visited[i][j] = true;

        if (trieNode == null) {
            trieNode = wordTrie.root;
        }
        TrieNodeBIG leaf = trieNode.child[c - 'A'];

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
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};

        char[][] arr = {{'a'}};
        boolean oath = exist(board, "ESE");
        System.out.println(oath);

    }


}


class TrieNodeBIG {
    public String val;
    public TrieNodeBIG[] child = new TrieNodeBIG[57];
    public boolean isLeaf = false;

    public TrieNodeBIG() {

    }
}

class WordTrieUpOrLow {
    public TrieNodeBIG root = new TrieNodeBIG();

    public void insert(String s) {
        TrieNodeBIG cur = root;
        for (char c : s.toCharArray()) {

            if (cur.child[c - 'A'] == null) {
                cur.child[c - 'A'] = new TrieNodeBIG();
                cur = cur.child[c - 'A'];
            } else
                cur = cur.child[c - 'A'];
        }
        cur.isLeaf = true;
        // 最后一个节点保存了单词本身
        cur.val = s;
    }
}

