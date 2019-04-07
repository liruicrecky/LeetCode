/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (36.91%)
 * Total Accepted:    169.7K
 * Total Submissions: 452.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {

    private final int ALPHABET_SIZE = 26;

    private class PrefixTree {

        private boolean isKey;

        private PrefixTree[] prefixTree;

        public PrefixTree() { 
            this.prefixTree = new PrefixTree[ALPHABET_SIZE]; 
            isKey = false;
        }
        public boolean getKey() { return isKey; }
        public boolean hasChar(char c) { return prefixTree[c - 'a'] != null; }
        public void putChar(char c) { prefixTree[c - 'a'] = new PrefixTree(); }
    }

    private PrefixTree root;

    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new PrefixTree();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        PrefixTree t = root;
        for (char c : chars) {
            if (!t.hasChar(c)) {
                t.putChar(c);
            }
            t = t.prefixTree[c - 'a'];
        }
        t.isKey = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        PrefixTree t = root;
        for (char c : chars) {
            if (!t.hasChar(c)) {
                return false;
            }
            t = t.prefixTree[c - 'a'];
        }
        return t.getKey();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        PrefixTree t = root;
        for (char c : chars) {
            if (!t.hasChar(c)) {
                return false;
            }
            t = t.prefixTree[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

