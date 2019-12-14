/*
 * @lc app=leetcode.cn id=1209 lang=java
 *
 * [1209] 删除字符串中的所有相邻重复项 II
 */

// @lc code=start
import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        // 统计字符
        Deque<Character> charDeque = new LinkedList<>();
        // 统计字符数量
        Deque<Integer> countDeque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (charDeque.isEmpty() || charDeque.peekLast() != c) {
                // 空栈或遇到了新的字符
                charDeque.offerLast(c);
                countDeque.offerLast(1);
            } else if (charDeque.peekLast() == c) {
                // 与前一个字符相同, 累加数量
                int count = countDeque.pollLast();
                count++;

                if (count == k) {
                    // 数量累加到k则删除
                    charDeque.pollLast();
                } else {
                    // 继续累加
                    countDeque.offerLast(count);
                }
            }
        }

        // 组合字符串
        StringBuilder stringBuilder = new StringBuilder();
        while (!charDeque.isEmpty()) {
            char c = charDeque.pollFirst();
            int count = countDeque.pollFirst();
            for (int i = 0; i < count; i++) {
                stringBuilder.append(c);
            }
        }


        return stringBuilder.toString();
    }
}
// @lc code=end

