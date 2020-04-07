/*
 * @lc app=leetcode.cn id=1399 lang=java
 *
 * [1399] 统计最大组的数目
 */

// @lc code=start
class Solution {
    public int countLargestGroup(int n) {
        int[] counts = new int[37];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int count = getCount(i);
            counts[count]++;
            max = Math.max(max, counts[count]);
        }

        int result = 0;
        for (int count : counts) {
            if (count == max) {
                result++;
            }
        }

        return result;
    }

    private int getCount(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
// @lc code=end
