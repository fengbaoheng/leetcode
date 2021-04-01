/*
 * @lc app=leetcode.cn id=1433 lang=java
 *
 * [1433] 检查一个字符串是否可以打破另一个字符串
 */

// @lc code=start
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        new Solution().checkIfCanBreak("abe", "acd");
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] c1 = count(s1);
        int[] c2 = count(s2);

        return canBreak(c1, c2) || canBreak(c2, c1);
    }


    private int[] count(String s) {
        int[] c = new int[26];

        for (char ch : s.toCharArray()) {
            c[ch - 'a']++;
        }

        return c;
    }

    private boolean canBreak(int[] c1, int[] c2) {
        c1 = Arrays.copyOf(c1, c1.length);
        c2 = Arrays.copyOf(c2, c2.length);

        for (int i = 0; i < 26; i++) {
            int consume = c1[i];
            if (consume == 0) {
                continue;
            }

            for (int j = i; j < 26; j++) {
                if (c2[j] >= consume) {
                    c2[j] -= consume;
                    consume = 0;
                    break;
                } else {
                    consume -= c2[j];
                    c2[j] = 0;
                }
            }

            if (consume > 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

