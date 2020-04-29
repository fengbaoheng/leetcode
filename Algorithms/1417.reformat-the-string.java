import java.util.*;

/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        Queue<Character> alpha = new LinkedList<>();
        Queue<Character> number = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                number.offer(ch);
            } else {
                alpha.offer(ch);
            }
        }

        int diff = Math.abs(alpha.size() - number.size());
        if (diff > 1) {
            return "";
        }

        boolean isNumber = number.size() >= alpha.size();

        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < s.length()) {
            stringBuilder.append(isNumber ? number.poll() : alpha.poll());
            isNumber = !isNumber;
        }

        return stringBuilder.toString();
    }
}
// @lc code=end
