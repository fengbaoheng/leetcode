/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.contains(B)) {
            return 1;
        }

        // 寻找可能的开头位置
        char headB = B.charAt(0);
        for (int p = 0; p < A.length(); p++) {
            if (A.charAt(p) == headB) {
                // 可以从p开始匹配
                int count = repeatedStringMatch(A, B, p);
                if (count != -1) {
                    return count;
                }
            }
        }

        return -1;
    }

    // 字符的逐个匹配
    private int repeatedStringMatch(String A, String B, int p) {
        int count = 1;

        for (int q = 0; q < B.length(); q++) {
            if (A.charAt(p) != B.charAt(q)) {
                return -1;
            }

            p++;
            if (p == A.length()) {
                p = 0;
                count++;
            }
        }

        // 最后一次无需重复
        if (p == 0) {
            count--;
        }

        return count;
    }
}
// @lc code=end

