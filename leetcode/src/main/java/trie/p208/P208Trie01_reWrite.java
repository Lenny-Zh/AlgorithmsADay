package trie.p208;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class P208Trie01_reWrite {

    private Node root;

    class Node {
        private int total = 26;
        private Node[] links = new Node[total];
        private boolean isEnd;

        public void add(char c, Node node) {
            links[c - 'a'] = node;
        }

        public Node get(char c){
            return links[c-'a'];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }

        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public P208Trie01_reWrite() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char s : word.toCharArray()) {
            Node thisNode = node.get(s);
            if (thisNode == null) {
                thisNode = new Node();
                node.add(s, thisNode);
            }
            node = thisNode;
        }
        node.setEnd();
    }


    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private Node searchPrefix(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }


    public static void main(String[] args) {
        P208Trie01_reWrite trie = new P208Trie01_reWrite();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }
}
