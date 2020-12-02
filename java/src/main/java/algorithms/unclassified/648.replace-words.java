/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */
import java.util.*;

class Solution {
    private Node tree = new Node(' ');


    public String replaceWords(List<String> dict, String sentence) {
        createTree(dict);

        String[] wordList = sentence.split(" ");

        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = replaceWord(wordList[i]);
        }

        return String.join(" ", wordList);
    }


    // 构造词根树
    // 只取最短的词根即可
    private void createTree(List<String> dict) {
        for (String word : dict) {
            // 由根节点向下添加
            Node node = tree;
            for (char c : word.toCharArray()) {
                // 存在比当前词根更短的词根
                if (node.isLeaf) {
                    break;
                }

                // 行下扩展树节点
                node = node.addChild(c);
            }

            // 最后一个节点设置为叶子节点标记词根结束
            node.isLeaf = true;
        }
    }

    // 替换单词
    private String replaceWord(String word) {
        if (word.length() <= 1) {
            return word;
        }

        char[] arr = word.toCharArray();
        int length = arr.length;
        Node node = tree;
        for (int i = 0; i < length; i++) {
            Node child = node.findChild(arr[i]);

            // 不包含词根 返回整个单词
            if (child == null) {
                break;
            }

            // 包含词根
            if (child.isLeaf) {
                return word.substring(0, i + 1);
            }

            // 词根的一部分 继续下一层判断
            node = child;
        }

        return word;
    }

    // 单词前缀树节点
    class Node {
        final char value;
        boolean isLeaf;
        Map<Character, Node> map = new HashMap<>();

        Node(char value) {
            this.value = value;
        }

        Node addChild(char childValue) {
            if (map.containsKey(childValue)) {
                return map.get(childValue);
            }

            Node child = new Node(childValue);
            map.put(childValue, child);
            return child;
        }

        Node findChild(char childValue) {
            return map.getOrDefault(childValue, null);
        }
    }
}

