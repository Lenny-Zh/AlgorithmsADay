package trie;

//字典树
public class WordTrie {
    public TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toLowerCase().toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else
                cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
        // 最后一个节点保存了单词本身
        cur.val = s;
    }
}

