/*
 * @lc app=leetcode.cn id=676 lang=java
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class MagicDictionary {

    DictNode root;

    public MagicDictionary() {
        this.root = new DictNode(' ');
    }

    public void buildDict(String[] dict) {
        for (String word : dict) {
            root.add(word, -1);
        }
    }

    public boolean search(String word) {
        for (DictNode child : root.children.values()) {
            if (child.search(word, 0, 0)) {
                return true;
            }
        }
        return false;
    }
}


class DictNode {
    char ch;
    boolean isWord = false;
    Map<Character, DictNode> children = new HashMap<>(26);

    public DictNode(char ch) {
        this.ch = ch;
    }

    void add(String word, int i) {
        if (i == word.length() - 1) {
            isWord = true;
            return;
        }

        char ch = word.charAt(i + 1);
        children.putIfAbsent(ch, new DictNode(ch));
        children.get(ch).add(word, i + 1);
    }

    boolean search(String word, int i, int count) {
        count += word.charAt(i) == ch ? 0 : 1;
        if (count > 1) {
            return false;
        }

        if (i == word.length() - 1) {
            return isWord && count == 1;
        }

        for (DictNode child : children.values()) {
            if (child.search(word, i + 1, count)) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

