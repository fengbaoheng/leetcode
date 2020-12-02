/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
    public int rotatedDigits(int N) {
        int[] rotateMap = new int[]{0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

        int count = 0;

        for (int i = 1; i <= N; i++) {
            // 逐位旋转
            int rotated = 0;
            int base = 1;
            boolean isValid = true;

            int raw = i;
            while (raw != 0) {
                // 获取末尾数位
                int d = raw % 10;

                // 旋转数位
                int dRotated = rotateMap[d];
                if (dRotated == -1) {
                    isValid = false;
                    break;
                }

                // 计算旋转后的数字
                rotated = rotated + base * dRotated;

                // 迭代更新下一位
                raw = raw / 10;
                base = base * 10;
            }

            // 旋转后判断是否相同
            if (isValid && rotated != i) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

