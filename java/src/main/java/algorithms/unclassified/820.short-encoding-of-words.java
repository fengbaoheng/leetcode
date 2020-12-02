/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().minimumLengthEncoding(new String[]{"time", "me", "bell"});
    }

    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        Map<String, Node> wordMap = new HashMap<>(words.length);

        for (String word : words) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                cur = cur.getChild(word.charAt(i));
            }
            wordMap.putIfAbsent(word, cur);
        }

        int res = 0;
        for (String word : wordMap.keySet()) {
            if (wordMap.get(word).hasChildren()) {
                continue;
            }
            res += word.length() + 1;
        }
        return res;
    }


    private static class Node {
        Map<Character, Node> children = new HashMap<>(26);

        Node getChild(char c) {
            return children.computeIfAbsent(c, k -> new Node());
        }

        boolean hasChildren() {
            return !children.isEmpty();
        }
    }
}
// @lc code=end

