package trie;

//字典树结点
public class TrieNode {
    public String val;
    public TrieNode[] child = new TrieNode[26];
    public boolean isLeaf = false;

    public TrieNode() {

    }
}


