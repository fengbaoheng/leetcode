/*
 * @lc app=leetcode.cn id=393 lang=java
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
class Solution {
    public boolean validUtf8(int[] data) {
        // 后续有count个10xxxxxx字节
        int count = 0;

        for (int b : data) {
            if (count == 0) {
                // 新分组的开头，计算该分组有几个字节
                count = byteCount(b);
                if (count == -1) {
                    return false;
                }
            } else {
                // 隶属某个分组中，检查是否为10xxxxxx格式
                if (!check10(b)) {
                    return false;
                }
                count--;
            }
        }

        return count == 0;
    }

    // 10000000
    static final int MASK_0 = 1 << 7;
    static final int RESULT_0 = 0;

    // 11100000
    static final int MASK_1 = MASK_0 | 1 << 6 | 1 << 5;
    static final int RESULT_1 = MASK_0 | 1 << 6;

    // 11110000
    static final int MASK_2 = MASK_1 | 1 << 4;
    static final int RESULT_2 = MASK_1;

    // 11111000
    static final int MASK_3 = MASK_2 | 1 << 3;
    static final int RESULT_3 = MASK_2;

    private int byteCount(int b) {
        if ((b & MASK_0) == RESULT_0) {
            return 0;
        } else if ((b & MASK_1) == RESULT_1) {
            return 1;
        } else if ((b & MASK_2) == RESULT_2) {
            return 2;
        } else if ((b & MASK_3) == RESULT_3) {
            return 3;
        } else {
            return -1;
        }
    }


    // 11000000
    static final int MASK_10 = 1 << 7 | 1 << 6;
    static final int RESULT_10 = 1 << 7;

    private boolean check10(int b) {
        return (b & MASK_10) == RESULT_10;
    }
}
// @lc code=end

