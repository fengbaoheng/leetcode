/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {


    public String decodeString(String s) {
        Deque<String> deque = new ArrayDeque<>();

        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                int start = i;
                while (i < n && Character.isLetter(s.charAt(i))) {
                    i++;
                }
                deque.offerLast(s.substring(start, i));
            } else if (Character.isDigit(c)) {
                int left = s.indexOf('[', i);
                String count = s.substring(i, left);
                deque.offerLast(count);
                deque.offerLast("[");
                i = left + 1;
            } else if (c == ']') {
                Deque<String> str = new ArrayDeque<>();
                while (!deque.peekLast().equals("[")) {
                    str.offerFirst(deque.pollLast());
                }
                deque.pollLast();
                int count = Integer.parseInt(deque.pollLast());
                String repeated = str.stream().collect(Collectors.joining());
                deque.offerLast(IntStream.range(0, count).mapToObj(k -> repeated).collect(Collectors.joining()));
                i++;
            }
        }

        return combine(deque);
    }

    private String combine(Deque<String> deque) {
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }
}
// @lc code=end

