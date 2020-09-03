/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
import java.util.*;

class Solution {
    // 贪心策略，每次从剩余最多的字符挑选
    public String reorganizeString(String S) {
        Node[] nodes = new Node[26];
        for (char c : S.toCharArray()) {
            int i = c - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node(c);
            } else {
                nodes[i].count++;
            }
        }

        // 为字符剩余次数排序
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node node : nodes) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        
        StringBuilder builder = new StringBuilder();

        Node pre = null, cur = null;
        for (int i = 0; i < S.length(); i++) {
            // 从剩余字符中挑选
            cur = queue.poll();
            if (cur == null) {
                return "";
            }

            // 累加
            cur.count--;
            builder.append(cur.ch);

            // 上个字符归队
            if (pre != null && pre.count > 0) {
                queue.offer(pre);
            }

            pre = cur;
        }

        return builder.toString();

    }


    private static class Node implements Comparable<Node> {
        private final char ch;
        private int count = 1;

        public Node(char ch) {
            this.ch = ch;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }
    }
}
// @lc code=end

