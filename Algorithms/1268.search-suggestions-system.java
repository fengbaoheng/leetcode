/*
 * @lc app=leetcode.cn id=1268 lang=java
 *
 * [1268] 搜索推荐系统
 */

// @lc code=start
import java.util.*;

class Solution {
    // 字典树
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TireTree tree = new TireTree(null);

        // 构造字典树
        for (String product : products) {
            tree.add(product, 0);
        }

        // 依次获取单词列表
        List<List<String>> results = new LinkedList<>();
        for (char c : searchWord.toCharArray()) {
            List<String> result = new LinkedList<>();

            if (tree != null) {
                tree = tree.getTree(c);
                if (tree != null) {
                    result.addAll(tree.getWords(3));
                }
            }

            results.add(result);
        }

        return results;
    }
}


/**
 * 字典树
 */
class TireTree {
    Character root = null;
    String word = null;

    TreeMap<Character, TireTree> map = new TreeMap<>();


    /**
     * 依据单词列表构造字典树
     */
    public TireTree(Character root) {
        this.root = root;
    }

    /**
     * 添加单词
     * @param word 单词
     * @param depth 深度
     */
    public void add(String word, int depth) {
        int len = word.length();
        if (depth > len) {
            return;
        } else if (depth == len) {
            this.word = word;
            return;
        }

        char root = word.charAt(depth);
        map.putIfAbsent(root, new TireTree(root));
        map.get(root).add(word, depth + 1);
    }

    /**
     * 依据首字母获取子树
     * @param c
     * @return
     */
    public TireTree getTree(char c) {
        return map.get(c);
    }

    /**
     * 获取单词列表
     * @param maxSize 最大单词个数
     * @return
     */
    public List<String> getWords(int maxSize) {
        List<String> words = new ArrayList<>(maxSize);

        if (this.word != null) {
            words.add(word);
        }

        for (TireTree subTree : map.values()) {
            words.addAll(subTree.getWords(maxSize - words.size()));
            if (words.size() >= maxSize) {
                break;
            }
        }

        if (words.size() <= maxSize) {
            return words;
        } else {
            List<String> result = new LinkedList<>();
            for (int i = 0; i < maxSize; i++) {
                result.add(words.get(i));
            }
            return result;
        }
    }
}
// @lc code=end

