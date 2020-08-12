/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        if (A > B) {
            return strWithout3a3b(A, 'a', B, 'b');
        } else {
            return strWithout3a3b(B, 'b', A, 'a');
        }
    }

    public String strWithout3a3b(int longer, char longerCh, int shorter, char shortCh) {
        StringBuilder builder = new StringBuilder();
        
        while (longer + shorter > 0) {
            // 贪心思想，根据长短字符数，交错插入
            int longCount = longer - shorter >= 2 ? 2 : 1;
            
            for (int j = 0; j < longCount && longer > 0; j++) {
                longer--;
                builder.append(longerCh);
            }

            if (shorter > 0) {
                shorter--;
                builder.append(shortCh);
            }
        }

        return builder.toString();
    }
}
// @lc code=end

