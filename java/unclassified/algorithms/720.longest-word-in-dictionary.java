/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
import java.util.*;


class Solution {
    public String longestWord(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (String word : words) {
            trieTree.insert(word);
        }
        return trieTree.dfs();
    }
}


/**
 * 前缀树节点
 */
class TrieNode {
    /**
     * 节点对应完整的单词
     */
    String word;

    /**
     * 节点子树
     */
    Map<Character, TrieNode> children = new HashMap<>();
}

/**
 * 前缀树
 */
class TrieTree {

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.word = word;
    }

    public String dfs() {
        String result = null;

        Queue<TrieNode> queue = new LinkedList<>(root.children.values());

        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();

            // 节点非字典中的单词
            // 无需继续向下搜索
            if (node.word == null) {
                continue;
            }

            // 比较并替换更优的结果
            if (betterWord(result, node.word)) {
                result = node.word;
            }

            // 添加子节点,继续搜索
            queue.addAll(node.children.values());
        }

        return result;
    }


    /**
     * @param oldWord 旧单词
     * @param newWord 新单词
     * @return 新单词是否为更好的单词
     */
    private boolean betterWord(String oldWord, String newWord) {
        if (oldWord == null) {
            return true;
        }

        // 通过长度比较
        if (newWord.length() != oldWord.length()) {
            return newWord.length() > oldWord.length();
        }

        // 长度相同,比较字典序
        return newWord.compareTo(oldWord) < 0;
    }
}
// @lc code=end

