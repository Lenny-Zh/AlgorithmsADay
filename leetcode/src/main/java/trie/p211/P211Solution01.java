package trie.p211;

import org.junit.Test;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word)
 * 如果数据结构中存在字符串与 word 匹配，则返回 true ；
 * 否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */
public class P211Solution01 {

    class Node {
        public Node[] sonNode = new Node[58];
        private boolean isEnd;

        public Node() {
        }

        public Node(char c) {
            sonNode[c - 'A'] = new Node();
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private Node root;

    public P211Solution01() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.sonNode[c - 'A'] == null) {
                node.sonNode[c - 'A'] = new Node();
            }
            node = node.sonNode[c - 'A'];
        }
        node.setEnd();
    }

    public boolean search(String word) {
       return searchHelper(root,word);
    }

    private boolean searchHelper(Node root,String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.toCharArray()[i];
            if (c == '.') {
                for (Node n : node.sonNode) {
                    if (n != null && searchHelper(n, word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.sonNode[c - 'A'] != null) {
                    node = node.sonNode[c - 'A'];
                } else {
                    return false;
                }
            }
        }
        return node != null && node.isEnd;
    }



    @Test
    public void test() {
        P211Solution01 wordDictionary = new P211Solution01();
        wordDictionary.addWord("and");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));


    }


}
