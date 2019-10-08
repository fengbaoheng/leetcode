/*
 * @lc app=leetcode.cn id=5205 lang=java
 *
 * [5205] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // -1000 <= arr[i] <= 1000
        int[] numCount = new int[2000];

        // 1 <= arr.length <= 1000
        int[] count = new int[1000];

        // 统计出现的次数
        // numCount[0~2000] 记录 数字-1000~1000 出现的次数
        for (int num : arr) {
            numCount[num + 1000]++;
        }

        for (int i = 0; i < 2000; i++) {
            int c = numCount[i];
            if (c == 0) {
                continue;
            } else if (count[c] != 0) {
                // 该次数已经出现过
                return false;
            } else {
                count[c] = 1;
            }
        }

        return true;
    }
}
// @lc code=end

