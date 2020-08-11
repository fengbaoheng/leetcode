/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
import java.util.*;

class WordDictionary {

    private final WordNode root = new WordNode(' ');

    public WordDictionary() {
    }


    public void addWord(String word) {
        root.add(word, 0);
    }

    public boolean search(String word) {
        return root.getChildren(word.charAt(0)).stream().anyMatch(node -> node.search(word, 1));
    }
}

class WordNode {
    private final char value;
    private boolean isWord;
    private final Map<Character, WordNode> children = new HashMap<>(26);

    public WordNode(char value) {
        this.value = value;
    }

    public void add(String word, int nextIndex) {
        int len = word.length();

        // 终止条件
        if (nextIndex >= len) {
            this.isWord = true;
            return;
        }

        char target = word.charAt(nextIndex);
        WordNode child = children.get(target);
        if (child == null) {
            child = new WordNode(target);
            children.put(target, child);
        }

        child.add(word, nextIndex + 1);
    }

    // 递归搜索
    public boolean search(String word, int nextIndex) {
        int len = word.length();

        // 终止条件
        if (nextIndex >= len) {
            return isWord;
        }

        char target = word.charAt(nextIndex);

        // 中间位置 递归搜索
        return getChildren(target).stream().anyMatch(node -> node.search(word, nextIndex + 1));
    }

    // 查找子节点
    public Collection<WordNode> getChildren(char c) {
        if (c == '.') {
            return children.values();
        }

        List<WordNode> results = new LinkedList<>();
        WordNode child = children.get(c);

        if (child != null) {
            results.add(child);
        }

        return results;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

