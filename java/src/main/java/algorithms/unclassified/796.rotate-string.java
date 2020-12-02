/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            // 长度不同
            return false;
        } else {
            // 长度相同且均为0
            if (A.length() == 0) {
                return true;
            }
        }


        // 复制两个A生成AA, 则从AA中判断是否包含B的子串即可
        String AA = A + A;
        for (int i = 0; i < AA.toCharArray().length; i++) {
            boolean isMatch = true;

            for (int j = 0; j < B.toCharArray().length; j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

