class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchComplete(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchComplete(prefix);
        return node != null;
    }
    
    private TrieNode searchComplete(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return null;
            }
            node = node.children[c - 'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class TrieNode {
    protected TrieNode[] children;
    protected boolean isEndOfWord;
    
    public TrieNode () {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}